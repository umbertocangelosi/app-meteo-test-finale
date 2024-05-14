import Cookies from "js-cookie";

export async function RegistrazioneUtente(userInfo) {
  const response = await fetch(
    "http://localhost:8080/api/utenti/registrazione",
    {
      mode: "cors",
      method: "POST",
      body: JSON.stringify(userInfo),
      headers: {
        "Content-Type": "application/json",
      },
    }
  ); //await attendiamo il completamento della fetch //fetch funzione embeddata dentro js
  return response; //la response é dentro la promise, i dati sono dentro una readablestream dentro la respone nel body che mi restituisce.
}

export async function LoginUtente(credentials) {
  const response = await fetch("http://localhost:8080/api/utenti/login", {
    mode: "cors",
    method: "POST",
    body: JSON.stringify(credentials),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return response;
}

export async function getCourses() {
  const response = await fetch("http://localhost:8080/api/corsi", {
    mode: "cors",
    method: "GET",
  });
  return response;
}


export async function getUsers() {
  const response = await fetch("http://localhost:8080/api/utenti", {
    mode: "cors",
    method: "GET",
  });
  return response;
}

export async function deleteUser(email) {
  const response = await fetch(`http://localhost:8080/api/utenti/${email}`, {
    mode: "cors",
    method: "DELETE",
  });
  return response;
}

export async function deleteCourse(id) {
  const response = await fetch(`http://localhost:8080/api/corsi/${id}`, {
    mode: "cors",
    method: "DELETE",
    headers:{
      "Content-Type": "application/json",
      "Authorization": `Bearer ${Cookies.get("token")}`
    }
  });
  return response;
}

export async function createCourse(courseInfo) {
  const response = await fetch(`http://localhost:8080/api/corsi`, {
    mode: "cors",
    method: "POST",
    body: JSON.stringify(courseInfo),
    headers:{
      "Content-Type": "application/json",
      "Authorization": `Bearer ${Cookies.get("token")}`
    }
  });
  return  response;
}

export async function getWeatherData(cityName, API_KEY) {
  const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${cityName}&appid=${API_KEY}&units=metric`,
  {
    mode: "cors",
    method: "GET",

  }
  );
  return response;
}

export async function saveWeatherData(weatherData) {
  const response = await fetch(`http://localhost:8080/api/meteo/registrazione`, {
    mode: "cors",
    method: "POST",
    body: JSON.stringify(weatherData),
    headers: {
      "Content-Type": "application/json",
    },
  });
  return response;
}