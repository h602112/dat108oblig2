const firstName = document.getElementById('firstname');
const lastName = document.getElementById('lastname');
const mobileNumber = document.getElementById('mobile');
const userPassword = document.getElementById('password');
const repeatedPassword = document.getElementById('passwordRepeated');
//function to check if first name fulfills validity requirements
function checkFirstName() {
    const value = firstName.value;
    if (!value || !(value.charAt(0).toUpperCase()===value.charAt(0)) || value.length < 2 || value.length >= 20) {
        firstName.style.backgroundColor = 'red';
    } else {
        firstName.style.backgroundColor = 'green';
    }
}
// function to check if last name fulfills validity requirements
function checkLastName() {
    const value = lastName.value;
    if (!value || !(value.charAt(0).toUpperCase()===value.charAt(0)) || value.length < 2 || value.length > 20
    || value.indexOf(' ') >= 0) {
        lastName.style.backgroundColor = 'red';
    } else {
        lastName.style.backgroundColor = 'green'
    }
}

// check validity of the users mobile number while typing
function checkMobileNumber() {
    const value = mobileNumber.value;
    if (!value || value.length > 8 || isNaN(value)) {
        mobileNumber.style.backgroundColor = 'red';
    } else {
        mobileNumber.style.backgroundColor = 'green';
    }
}

// check validity of the users password
function checkPassword() {
    const value = userPassword.value;
    // find number of large letters in the typed password
    let largeLetterCount = 0;
    for (let i = 0; i < value.length; i++) {
        if (value.charAt(i).toUpperCase()===value.charAt(i)) {
            largeLetterCount++;
        }
    }
    //find number of numbers in the typed password
    let numberCounter = 0;
    for (let i = 0; i < value.length; i++) {
        if (!(isNaN(value.charAt(i)))) {
            numberCounter++;
        }
    }
    if (!value || value.length <= 5 || largeLetterCount < 2 || numberCounter < 2) {
        userPassword.style.backgroundColor = 'red';
    }  else if (!value || value.length <= 7 || largeLetterCount < 3 || numberCounter < 3) {
        userPassword.style.backgroundColor = 'yellow';
    } else {
        userPassword.style.backgroundColor = 'green';
    }
}
// check if the repeated password is the same as user password
function checkRepeatedPassword() {
    if (repeatedPassword.value===userPassword.value) {
        repeatedPassword.style.backgroundColor = 'green';
    } else {
        repeatedPassword.style.backgroundColor = 'red';
    }
}


