const userName = document.getElementById('username');
const firstName = document.getElementById('first-name');
const lastName = document.getElementById('last-name');
const countryCode = document.getElementById('country-code');
const phoneNumber = document.getElementById('phone-number');
const email = document.getElementById('email');
const ageGroup = document.getElementById('age-group');
const desiredTeam = Array.from(document.getElementsByName('desired-team'));
const desiredPositions = Array.from(document.getElementsByName('desired-position'));
const address = document.getElementById('address');
const pinCode = document.getElementById('pin-code');
const country = document.getElementById('country');
const state = document.getElementById('state');
const city = document.getElementById('city');

const getSelectedTeam = () => {
	const team = desiredTeam.find((team) => team.checked)
	return team ? team.value : null
}

const getSelectedPositions = () => {
	const positions = desiredPositions
		.filter((position) => position.checked)
		.map((position) => position.value)
	return positions.length ? positions : null
}

const collectFormDetails = () => ({
	userName: userName.value,
	firstName: firstName.value,
	lastName: lastName.value.trim(),
	countryCode: countryCode.value,
	phoneNumber: phoneNumber.value,
	email: email.value,
	ageGroup: ageGroup.value,
	address: address.value,
	city: city.value,
	state: state.value,
	country: country.value,
	pinCode: pinCode.value,
	desiredTeam: getSelectedTeam(),
	desiredPositions: getSelectedPositions(),
});

const registerUser = (formData, requestType) => {
	validateFields();

	fetch('http://localhost:8080/api/v1/football', {
		method: requestType,
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(formData),
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode === 200) console.log("Data saved successfully")
			else console.log(data.errorMessage)
		})
		.catch((error) => {
			console.log("Something went wrong: " + error)
		})
}


// Validations

const validateFields = () => {
	let isUserNameValid = userName.checkValidity();
	if(!isUserNameValid) {
		userName.reportValidity();
		return false;
	}

	let isFirstNameValid = firstName.checkValidity();
	if(!isFirstNameValid) {
		firstName.reportValidity();
		return false;
	}

	let isLastNameValid = lastName.checkValidity();
	if(!isLastNameValid) {
		lastName.reportValidity();
		return false;
	}

	let isPhoneNumberValid = phoneNumber.checkValidity();
	if(!isPhoneNumberValid) {
		phoneNumber.reportValidity();
		return false;
	}

	let isEmailValid = email.checkValidity();
	if(!isEmailValid) {
		email.reportValidity();
		return false;
	}
	
	return true;
}

// Username
userName.addEventListener('username-blank', (e) => {
	e.target.setCustomValidity("Username cannot be blank");
});

userName.addEventListener('username-too-large', (e) => {
	e.target.setCustomValidity("Username is too large");
});

userName.addEventListener('username-invalid', (e) => {
	e.target.setCustomValidity("Invalid Username");
});

userName.checkValidity = () => {
	if(userName.value.length === 0){
		userName.dispatchEvent(new Event('username-blank'));
		return false;
	} else if (userName.value.length > 255) {
		userName.dispatchEvent(new Event('username-too-large'));
		return false;
	} else if(!userName.value.match("[A-Za-z0-9]+")){
		userName.dispatchEvent(new Event('username-invalid'));
		return false;
	}
	return true;
}


// First Name
firstName.addEventListener('firstName-blank', (e) => {
	e.target.setCustomValidity("First Name cannot be blank");
});

firstName.addEventListener('firstName-too-large', (e) => {
	e.target.setCustomValidity("First Name is too large");
});

firstName.addEventListener('firstName-invalid', (e) => {
	e.target.setCustomValidity("First Name is invalid");
});

firstName.checkValidity = () => {
	if(firstName.value.length === 0){
		firstName.dispatchEvent(new Event('firstName-blank'));
		return false;
	} else if (firstName.value.length > 255) {
		firstName.dispatchEvent(new Event('firstName-too-large'));
		return false;
	} else if(!firstName.value.match("[A-Za-z0-9]+")){
		firstName.dispatchEvent(new Event('firstName-invalid'));
		return false;
	}
	return true;
}


// Last Name
lastName.addEventListener('lastName-too-large', (e) => {
	e.target.setCustomValidity("Last Name is too large");
});

lastName.addEventListener('lastName-invalid', (e) => {
	e.target.setCustomValidity("Last Name is invalid");
});

lastName.checkValidity = () => {
	if (lastName.value.length > 255) {
		lastName.dispatchEvent(new Event('lastName-too-large'));
		return false;
	} else if(!lastName.value.match("[A-Za-z0-9]+")){
		lastName.dispatchEvent(new Event('lastName-invalid'));
		return false;
	}
	return true;
}


// Phone number
phoneNumber.addEventListener('phoneNumber-blank', (e) => {
	e.target.setCustomValidity("Phone number cannot be blank");
});

phoneNumber.addEventListener('phoneNumber-too-large', (e) => {
	e.target.setCustomValidity("Phone number is too large");
});

phoneNumber.addEventListener('phoneNumber-invalid', (e) => {
	e.target.setCustomValidity("Invalid phone number");
});

phoneNumber.checkValidity = () => {
	if(phoneNumber.value.length === 0) {
		phoneNumber.dispatchEvent(new Event('phoneNumber-blank'));
	} else if (phoneNumber.value.length >= 15) {
		phoneNumber.dispatchEvent(new Event('phoneNumber-too-large'));
		return false;
	} else if(!phoneNumber.value.match("[0-9]+")){
		phoneNumber.dispatchEvent(new Event('phoneNumber-invalid'));
		return false;
	}
	return true;
}


// Email
email.addEventListener('email-blank', (e) => {
	e.target.setCustomValidity("Email cannot be blank");
});

email.addEventListener('email-too-large', (e) => {
	e.target.setCustomValidity("Email is too large");
});

email.addEventListener('email-invalid', (e) => {
	e.target.setCustomValidity("Email is invalid");
});

email.checkValidity = () => {
	if(email.value.length === 0){
		email.dispatchEvent(new Event('email-blank'));
		return false;
	} else if (email.value.length > 255) {
		email.dispatchEvent(new Event('email-too-large'));
		return false;
	} else if(!email.value.match(/^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/)){
		email.dispatchEvent(new Event('email-invalid'));
		return false;
	}
	return true;
}
