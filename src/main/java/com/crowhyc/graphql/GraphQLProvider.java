package com.crowhyc.graphql;

import com.crowhyc.graphql.bookdetails.GraphQLDataFetcher;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URL;

import static graphql.schema.idl.TypeRuntimeWiring.newTypeWiring;

/**
 * <p>
 * Description: com.crowhyc.graphql.game
 * </p>
 * date：2019/12/1
 * email:crowhyc@163.com
 *
 * @author Dean.Hwang
 */
@Component
public class GraphQLProvider {

    private GraphQL graphQL;
    @Autowired
    GraphQLDataFetcher graphQLDataFetchers;

    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }

    @PostConstruct
    public void init() throws IOException {
        URL url = Resources.getResource("schema.graphql");
        String sdl = Resources.toString(url, Charsets.UTF_8);
        GraphQLSchema graphQLSchema = buildSchema(sdl);
        this.graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    private GraphQLSchema buildSchema(String sdl) {
        TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(sdl);
        RuntimeWiring runtimeWiring = buildWiring();
        SchemaGenerator schemaGenerator = new SchemaGenerator();
        return schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                            .type(newTypeWiring("Query")
                                    .dataFetcher("bookById", graphQLDataFetchers.getBookByIdDataFetcher()))
                            .type(newTypeWiring("Book")
                                    .dataFetcher("author", graphQLDataFetchers.getAuthorDataFetcher()))
                            .build();
    }
}
