package utils;

import constants.FieldErrorMessage;
import constants.FieldIdentifier;
import org.openqa.selenium.NotFoundException;

public class Magic {

    public static String getFieldErrorMessage(String fieldId){
        return switch (fieldId) {
            case FieldIdentifier.FIRST_NAME_ID -> FieldErrorMessage.FIRST_NAME_ID_ERROR;
            case FieldIdentifier.LAST_NAME_ID -> FieldErrorMessage.LAST_NAME_ID_ERROR;
            case FieldIdentifier.ADDRESS_ID -> FieldErrorMessage.ADDRESS_ID_ERROR;
            case FieldIdentifier.CITY_ID -> FieldErrorMessage.CITY_ID_ERROR;
            case FieldIdentifier.STATE_ID -> FieldErrorMessage.STATE_ID_ERROR;
            case FieldIdentifier.ZIPCODE_ID -> FieldErrorMessage.ZIPCODE_ID_ERROR;
            case FieldIdentifier.SSN_ID -> FieldErrorMessage.SSN_ID_ERROR;
            case FieldIdentifier.USERNAME_ID -> FieldErrorMessage.USERNAME_ID_ERROR;
            case FieldIdentifier.PASSWORD_ID -> FieldErrorMessage.PASSWORD_ID_ERROR;
            case FieldIdentifier.CONFIRM_ID -> FieldErrorMessage.CONFIRM_ID_ERROR;
            default -> throw new NotFoundException(String.format("No error message found associated with %s fieldId.", fieldId));
        };
    }
}
