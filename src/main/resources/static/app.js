document.addEventListener("DOMContentLoaded", () =>
{
    const contactsList = document.querySelector("#contacts-list"); // tbody#contacts-list
    contactsList.addEventListener("click", e =>
    {
        if(e.target.id === "delete-contact-button") // Verificar si presionó el botón de eliminar contacto
        {
            if(confirm("¿Estás seguro que quieres eliminar este contacto? Esta acción es irreversible!")) return 1;
            else e.preventDefault();
        }
    });
});

