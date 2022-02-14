var countrySelectElement = document.getElementById('country');
var countryCodeSelectElement = document.getElementById("country-code");
var stateSelectElement = document.getElementById('state');
var citySelectElement = document.getElementById('city');
var ageGroupSelectElement = document.getElementById("age-group");
var btnSubmit = document.getElementById('submit-btn');


function removeOptions(selectElement) {
    var i, L = selectElement.options.length - 1;
    for(i = L; i >= 0; i--) {
       selectElement.remove(i);
    }
 }