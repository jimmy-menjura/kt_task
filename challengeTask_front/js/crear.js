const URL = "http://localhost:8090/api";

document.getElementById("form").addEventListener("submit", function (event) {
  event.preventDefault();
  const title = document.getElementById("title").value;
  const description = document.getElementById("description").value;
  if (title === "") {
    alert("Llene el campo titulo no puede ser vacío");
    return;
  }
  if (description === "") {
    alert("Llene el campo descripcion no puede ser vacío");
    return;
  }
  if (title !== "" && description !== "") {
    fetchGuardar(title, description);
  }
});
function fetchGuardar(title, description) {
  let datos = {
    title: title,
    description: description,
  };
  fetch(`${URL}/saveTask`, {
    method: "POST",
    headers: {
      Accept: "application/json, text/plain",
      "Content-Type": "application/json;charset=UTF-8",
    },
    body: JSON.stringify(datos),
  }).then((response) => {
    if (response.status === 200) {
      window.location.href = "index.html";
    }
  });
}