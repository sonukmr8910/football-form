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
	desiredPosition: getSelectedPositions(),
});


btnSubmit.addEventListener('click', () => {    
    console.log("Submit clicked");
    const formData = collectFormDetails();
	console.log(formData);
    registerUser(formData);
});

const registerUser = (formData) => {
	fetch('http://localhost:8080/api/v1/football', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: JSON.stringify(formData),
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode === 200) console.log("Data saved successfully")
			else console.log("There wa an error in saving data")
		})
		.catch((error) => {
			console.log("Something went wrong: " + error)
		})
}