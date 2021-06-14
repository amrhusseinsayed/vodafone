@rest
Feature: Posts Feature

  Scenario: Get all posts
    Given admin gets all the posts
    Then verify that a status code of 200 is received from the called API
    And the number of posts in the response equals 100

  Scenario: Get post by id
    Given admin gets the post with id '1'
    Then verify that a status code of 200 is received from the called API
    And the 'id' in the response json equals 1

  Scenario: Add new post
    Given admin adds a post with the key 'post1'
    Then verify that a status code of 201 is received from the called API
    And the response json contains all the data of 'post1'