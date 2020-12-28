package service;

import model.User;

public class UserCreator {
    public static final String TESTDATA_USER_PHONE = "testdata.user.phone";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    public static User createUserFromProperties(){
        return new User(Integer.parseInt(TestDataReader.getTestData(TESTDATA_USER_PHONE)),
                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
    }
}
