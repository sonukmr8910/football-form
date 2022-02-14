document.addEventListener('DOMContentLoaded', () => {
	//Filling Country Codes
	fetch('http://localhost:8080/api/v1/countrycode', {
		method: 'GET',
		redirect: 'follow'
	})
		.then((response) => response.json())
		.then((data) => {
			if (data.httpStatusCode != 200) throw new Error('There was an error in fetching country codes')

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
			countrySelectElement.dispatchEvent(new Event('change'));
		})
		.catch((error) => {
			console.log("Cannot fetch using countries endpoint")
		});
});


countrySelectElement.addEventListener('change', () => {
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
			stateSelectElement.dispatchEvent(new Event('change'));
		})
		.catch(err => {
			console.log("There was an error in fetching states");
		});
});

stateSelectElement.addEventListener('change', () => {
	removeOptions(citySelectElement);

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
});
