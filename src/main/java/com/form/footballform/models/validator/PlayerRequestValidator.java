package com.form.footballform.models.validator;

public abstract class PlayerRequestValidator implements RequestValidator {

    public abstract boolean isUsernameValid();

    public abstract boolean isFirstNameValid();

    public abstract boolean isLastNameValid();

    public abstract boolean isPhoneNumberValid();

    public abstract boolean isEmailValid();

    public abstract boolean isAgeGroupValid();

    public abstract boolean isAddressValid();

    public abstract boolean isCompleteAddressValid();

    public abstract boolean isCityValid();

    public abstract boolean isStateValid();

    public abstract boolean isCountryValid();

    public abstract boolean isPinCodeValid();

    public abstract boolean isDesiredTeamValid();

    public abstract boolean isDesiredPositionValid();
}
