$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:features/AmazonHomePage.feature");
formatter.feature({
  "name": "Search Feature on Amazon.com",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@SEARCHITEMS"
    }
  ]
});
formatter.scenario({
  "name": "Search Validation with Lego",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@SEARCHITEMS"
    },
    {
      "name": "@SEARCHITEMS1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User is on Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "stepDefinitions.AmazonHomePageSteps.user_is_on_Home_Page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User searches for \"LEGO\"",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.AmazonHomePageSteps.user_searches_for(java.lang.String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "products related to search must appear",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.AmazonSearchResultsPage.products_related_to_search_must_appear()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});