package stepDefs;

import Utilities.CacheStorage;
import Utilities.ConfigFileReader;
import Utilities.ScenarioManager;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestAPIStepdef {

    @Then("^I verify (get|post|put|delete)Service for \"(.*)\" has status (\\d+) on \"(.*)\" with header params \"(.*)\", path params \"(.*)\", query params \"(.*)\", form params \"(.*)\", auth \"(.*)\", body \"(.*)\"$")
    public void i_validate_rest_service(String method, String storingkey, int statusCode, String URL, String headerkey, String pathkey, String querykey, String formkey, String auth, String body) throws Exception {

        String url = ConfigFileReader.getPropertyValue(URL);
        RequestSpecification request = given();
        Response response = null;

        if (!pathkey.equals("")) request = request.pathParams(CacheStorage.getCacheParam(pathkey));
        if (!auth.equals("")) request = request.auth().basic(CacheStorage.getCacheParam(auth).get("username"), CacheStorage.getCacheParam(auth).get("password"));
        if (!headerkey.equals("")) request = request.headers(CacheStorage.getCacheParam(headerkey));
        if (!querykey.equals("")) request = request.queryParams(CacheStorage.getCacheParam(querykey));
        if (!formkey.equals("")) request = request.formParams(CacheStorage.getCacheParam(formkey));
        if (!body.equals("")) request = request.body(new JSONObject(CacheStorage.getCacheParam(body)));

        switch (method) {
            case "get":
                response = request.get(url);
                break;
            case "post":
                response = request.post(url);
                break;
            case "put":
                response = request.put(url);
                break;
            case "delete":
                response = request.delete(url);
                break;
            default:
                throw new Exception("Method name is incorrect");
        }

        response.then().assertThat().statusCode(statusCode);
        CacheStorage.setResponse(storingkey, response);
        ScenarioManager.getScenario().write("Rest service call completed with status code " + statusCode + ". Response json:\r\n" + CacheStorage.getResponse(storingkey).asString());
    }

    @Then("^I store parameters in (\\w+) map$")
    public void i_store_map(String key, Map<String, String> params) {
        Map<String, String> paramsMap = new HashMap<>();
        for (Map.Entry<String, String> param : params.entrySet()) {
            paramsMap.put(param.getKey(), param.getValue());
        }
        CacheStorage.setCacheParam(key, paramsMap);
    }

    @Then("^I verify rest response data for (\\w+)$")
    public void i_verify_rest_response(String retrievingkey, Map<String, String> expectedmap) throws Exception {
        boolean pass = true;
        Response response = CacheStorage.getResponse(retrievingkey);

        for (Map.Entry<String, String> param : expectedmap.entrySet()) {
            String paramKey;
            String paramValue = "";
            String respValue;
            Object rspVl;
            paramKey = param.getKey();
            rspVl = response.then().extract().path(paramKey);
            if (rspVl != null) {
                respValue = String.valueOf(rspVl).trim();
            } else {
                respValue = String.valueOf(rspVl);
            }


            if (paramKey.equals("cell_phone")) {
                String tempParamValue = param.getValue();

                for (int i = 0; i < tempParamValue.length(); i++) {
                    if (i == 0) {
                        paramValue = paramValue + "(" + tempParamValue.charAt(i);
                    } else if (i == 2) {
                        paramValue = paramValue + tempParamValue.charAt(i) + ") ";
                    } else if (i == 5) {
                        paramValue = paramValue + tempParamValue.charAt(i) + "-";
                    } else {
                        paramValue = paramValue + tempParamValue.charAt(i);
                    }

                }
                System.out.println("original format cell phone: " + respValue);
                System.out.println("new format cell phone: " + paramValue);


            } else {
                paramValue = param.getValue();

            }
            if (respValue.equals(paramValue)) {
                ScenarioManager.getScenario().write("Pass; Found " + paramKey + " : " + respValue);
            } else {
                pass = false;
                ScenarioManager.getScenario().write("Fail; Expected " + paramValue + "; Found " + paramKey + " : " + respValue);
            }

        }
        if (!pass) throw new Exception("Fail! Check outputs below for details.");
    }


    @Then("I verify rest response data contains for {string}")
    public void iVerifyRestResponseDataContainsFor(String retrievingkey, List<String> expectedvalues) throws Exception {
        boolean fail = false;
        String rsp = CacheStorage.getResponse(retrievingkey).asString();
        String expectedValue = "";

        for (int i = 0; i < expectedvalues.size(); i++) {
            expectedValue = expectedvalues.get(i);

            if (!rsp.contains(expectedValue)) {
                ScenarioManager.getScenario().write(" Fail; Could not find " + expectedValue + " in response");
                fail = true;
            } else {
                ScenarioManager.getScenario().write(" Pass; " + expectedValue + " is present in response");
            }

        }
        if (fail) {
            throw new Exception(" Fail; Could not find " + expectedValue + " in response");
        }
    }

    @Then("I verify {string} postMethod created data with {string}")
    public void iVerifyPostMethodCreatedDataWith(String id, String bodyKey) throws Exception {
        boolean pass = true;

        String ID = CacheStorage.getResponse(id).asString();
        Map<String, String> rsBody = CacheStorage.getCacheParam(bodyKey);
        String url = ConfigFileReader.getPropertyValue("getStaffInfo");
        RequestSpecification request = given();
        Response response = null;
        request = request.pathParam("staff_id", ID);
        response = request.get(url);
        response.then().assertThat().statusCode(200);

        for (Map.Entry<String, String> param : rsBody.entrySet()) {
            String paramKey;
            String paramValue = "";
            String respValue;
            Object rspVl;
            paramKey = param.getKey();
            rspVl = response.then().extract().path(paramKey);
            if (rspVl != null) {
                respValue = String.valueOf(rspVl).trim();
            } else {
                respValue = String.valueOf(rspVl);
            }

            if (paramKey.equals("cell_phone")) {
                String tempParamValue = param.getValue();

                for (int i = 0; i < tempParamValue.length(); i++) {
                    if (i == 0) {
                        paramValue = paramValue + "(" + tempParamValue.charAt(i);
                    } else if (i == 2) {
                        paramValue = paramValue + tempParamValue.charAt(i) + ") ";
                    } else if (i == 5) {
                        paramValue = paramValue + tempParamValue.charAt(i) + "-";
                    } else {
                        paramValue = paramValue + tempParamValue.charAt(i);
                    }

                }
                System.out.println("original format cell phone: " + respValue);
                System.out.println("new format cell phone: " + paramValue);

            } else {
                paramValue = param.getValue();

            }

            if (respValue.equals(paramValue)) {
                ScenarioManager.getScenario().write("Pass; Found " + paramKey + " : " + respValue);
            } else {
                pass = false;
                ScenarioManager.getScenario().write("Fail; Expected " + paramValue + "; Found " + paramKey + " : " + respValue);
            }

        }
        if (!pass) throw new Exception("Fail! Check outputs below for details.");
    }

    @Then("I delete {string} staff")
    public void iDeleteStaff(String id) {
        String ID = CacheStorage.getResponse(id).asString();
        String url = ConfigFileReader.getPropertyValue("postExit");
        RequestSpecification request = given();
        Response response = null;

        request.pathParams("staff_id",ID);
        request = request.formParams("exit_date","03/23/2020","exit_reason","RES");
        request = request.formParams("exit_reason","RES");

        response = request.post(url);


        response.then().assertThat().statusCode(200);

        ScenarioManager.getScenario().write("Rest service call completed with status code 200 and Staff "+ ID+" deleted ");

    }

}
