const URL = "http://localhost:8090/api";

document.addEventListener("DOMContentLoaded", function (event) {
  obtenerTareas();
});

function obtenerTareas() {
  fetch(`${URL}/getTask`)
    .then((response) => response.json())
    .then((data) => {
      data.map((datos) => {
        const { id, title, description } = datos;
        let tbody = document.getElementById("body");

        let tr = document.createElement("tr");

        let th = document.createElement("td");
        th.innerHTML = title;

        let th2 = document.createElement("td");
        th2.innerHTML = description;

        let button = document.createElement("button");
        button.innerHTML = "Eliminar";
        button.className = "button";
        button.onclick = async function () {
          try {
            const respuesta = await fetch(`${URL}/deleteTask/${id}`, {
              method: "DELETE",
            });

            const data = respuesta.json();
            data.then((result) => {
              if (result) {
                window.location.reload();
              }
            });
          } catch (error) {
            console.log(error);
          }
        };
        tbody.appendChild(tr);
        tr.appendChild(th);
        tr.appendChild(th2);
        tr.appendChild(button);
      });
    })
    .catch((e) => {
      console.log("exception ", e);
    });
}

