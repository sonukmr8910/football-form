var isNewRecord = true;

document.addEventListener('DOMContentLoaded', () => {
	//Filling Country Codes
	fetch('http://localhost:8080/api/v1/countrycode', {
		method: 'GET',
		redirect: 'follow'
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error('Cannot fetch country codes');

			data.data
				.map((countryCode) => {
					const optCountry = document.createElement('option')
					optCountry.innerText = countryCode.code;
					optCountry.setAttribute('value', countryCode.id)
					countryCodeSelectElement.append(optCountry);
				});
		})
		.catch((error) => {
			console.log("Cannot fetch using countries endpoint")
		});

	//Filling AgeGroups
	fetch('http://localhost:8080/api/v1/agegroup', {
		method: 'GET',
		redirect: 'follow',
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error('There was an error in fetching country codes')

			data.data
				.map((ageGroup) => {
					const optCountry = document.createElement('option')
					optCountry.innerText = ageGroup.name;
					optCountry.setAttribute('value', ageGroup.id)
					ageGroupSelectElement.append(optCountry);
				});
		})
		.catch((error) => {
			console.log("Cannot fetch using countries endpoint")
		});

		fillAllCountries(null, true);
});

var searchBtn = document.getElementById('search-btn');
var userNameField = document.getElementById('username');
userNameField.addEventListener('keyup', () => {
	btnSubmit.innerText = "Phewww! Let's submit it";
	isNewRecord = true;

	fetch('http://localhost:8080/api/v1/football/exists/' + userNameField.value.trim(), {
		method: 'GET',
		redirect: 'follow'
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error(data.httpStatusCode)
			if(data.message == "true"){
				searchBtn.classList.remove('btn-outline-secondary')
				searchBtn.classList.add('btn-success');
				searchBtn.classList.add('text-light');
			}
			else{
				searchBtn.classList.add('btn-outline-secondary')
				searchBtn.classList.remove('btn-success');
				searchBtn.classList.remove('text-light');
			}
		})
		.catch(err => {
			console.log("There was an error in fetching cities");
		});
});

const fillAllCountries = (initialValue, callEvent) => {
	removeOptions(countrySelectElement);
	//Filling Countries
	fetch('http://localhost:8080/api/v1/country', {
		method: 'GET',
		redirect: 'follow',
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error('There was an error in fetching country codes')

			data.data
				.map((country) => {
					const optCountry = document.createElement('option')
					optCountry.innerText = country.name;
					optCountry.setAttribute('value', country.id)
					countrySelectElement.append(optCountry);
			});
			if(initialValue)
				countrySelectElement.value = initialValue;
			if(callEvent)
				countrySelectElement.dispatchEvent(new Event('change'));
		})
		.catch((error) => {
			console.log("Cannot fetch using countries endpoint")
		});
};

searchBtn.addEventListener('click', () => {
	if(searchBtn.classList.contains('btn-success')) {

		fetch('http://localhost:8080/api/v1/football/user/' + userNameField.value.trim(), {
			method: 'GET',
			redirect: 'follow'
		})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error(data.httpStatusCode)
			var player = data.data;
			firstName.value = player.firstName;
			lastName.value = player.lastName;
			phoneNumber.value = player.phoneNumber;
			email.value = player.email;
			ageGroup.selectedIndex = player.ageGroup;
			address.value = player.address.address;
			pinCode.value = player.address.pinCode;
			var desiredteamNames = Array.from(document.getElementsByName('desired-team'));
			desiredteamNames.map((ele) => {
				if(ele.value == player.desiredTeam.id)
					ele.checked = true;
			});

			var desiredPositionNames = Array.from(document.getElementsByName('desired-position'));
			desiredPositionNames.map((ele) => {
				ele.checked = false;
				player.desiredPositions.forEach((p) => {
					if(p.id == ele.value)
						ele.checked = true;
				});
			});

			removeOptions(countrySelectElement);
			//Filling Countries
			fetch('http://localhost:8080/api/v1/country', {
				method: 'GET',
				redirect: 'follow',
			})
			.then((response) => response.json())
			.then((data) => {
				if (data.httpStatusCode != 200) throw new Error('There was an error in fetching country codes')

				data.data
					.map((country) => {
						const optCountry = document.createElement('option')
						optCountry.innerText = country.name;
						optCountry.setAttribute('value', country.id)
						countrySelectElement.append(optCountry);
					});
					countryCodeSelectElement.value = player.address.city.state.country.id;

					// Filling States
					removeOptions(stateSelectElement);
					removeOptions(citySelectElement);
					fetch('http://localhost:8080/api/v1/states/' + countrySelectElement.options[countrySelectElement.selectedIndex].value, {
						method: 'GET',
						redirect: 'follow'
					})
					.then((response) => response.json())
					.then((data) => {
						if (data.httpStatusCode != 200) throw new Error('There was an error in fetching states')
						data.data.map((state) => {
						const optState = document.createElement('option');
						optState.innerText = state.name;
						optState.setAttribute('value', state.id);
						stateSelectElement.append(optState);
						});
						stateSelectElement.value = player.address.city.state.id;
						
						//Filling Cities
						fetch('http://localhost:8080/api/v1/cities/' + stateSelectElement.options[stateSelectElement.selectedIndex].value, {
							method: 'GET',
							redirect: 'follow'
						})
						.then((response) => response.json())
						.then((data) => {
							if (data.httpStatusCode != 200) throw new Error('There was an error in fetching cities api')
							data.data.map((city) => {
								const optCity = document.createElement('option');
								optCity.innerText = city.name;
								optCity.setAttribute('value', city.id);
								citySelectElement.append(optCity);
							});

						})
						.catch(err => {
							console.log("There was an error in fetching cities");
						});
					})
					.catch(err => {
						console.log("There was an error in fetching states");
					});
				})
				.catch((error) => {
					console.log("Cannot fetch using countries endpoint")
				});
			
			btnSubmit.innerText = "Update User Data";
			isNewRecord = false;
		})
		.catch(err => {
			console.log("Cannot fetch user data");
			console.log(err);
		});
	}
	else {
		btnSubmit.innerText = "Phewww! Let's submit it";
		isNewRecord = true;
	}
});

countrySelectElement.addEventListener('change', () => {
	removeOptions(stateSelectElement);
	removeOptions(citySelectElement);

	fillAllStates(true);
});


const fillAllStates = (initialValue, callEvent) => {
	fetch('http://localhost:8080/api/v1/states/' + countrySelectElement.options[countrySelectElement.selectedIndex].value, {
		method: 'GET',
		redirect: 'follow'
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error('There was an error in fetching states')
			data.data.map((state) => {
				const optState = document.createElement('option');
				optState.innerText = state.name;
				optState.setAttribute('value', state.id);
				stateSelectElement.append(optState);
			});
			stateSelectElement.value = initialValue;
			if(callEvent)
				stateSelectElement.dispatchEvent(new Event('change'));
		})
		.catch(err => {
			console.log("There was an error in fetching states");
		});
}

const fillAllCities = (initialValue) => {
	fetch('http://localhost:8080/api/v1/cities/' + stateSelectElement.options[stateSelectElement.selectedIndex].value, {
		method: 'GET',
		redirect: 'follow'
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error('There was an error in fetching cities api')
			data.data.map((city) => {
				const optCity = document.createElement('option');
				optCity.innerText = city.name;
				optCity.setAttribute('value', city.id);
				citySelectElement.append(optCity);
			});
			if(initialValue)
				citySelectElement.value = initialValue;
		})
		.catch(err => {
			console.log("There was an error in fetching cities");
		});
}

stateSelectElement.addEventListener('change', () => {
	removeOptions(citySelectElement);

	fillAllStates(null, true);	
});


btnSubmit.addEventListener('click', () => {    
	const formData = collectFormDetails();

	if(isNewRecord)
		registerUser(formData, 'POST');
	else
		registerUser(formData, 'PUT');
});