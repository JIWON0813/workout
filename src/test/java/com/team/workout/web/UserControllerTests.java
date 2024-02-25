package com.team.workout.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
public class UserControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @DisplayName("1. 게시글 1개 가져오기")
    @Test
    void test_1(){
        var asd = this.graphQlTester.documentName("User")
                .variable("id", 1)
                .execute();

    }
}
