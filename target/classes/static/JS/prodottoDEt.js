// Ottenere tutti gli elementi dei bottoni delle taglie
var sizeButtons = document.getElementsByClassName("size-button");

// Aggiungere un evento di click a ciascun bottone
Array.from(sizeButtons).forEach(function(button) {
  button.addEventListener("click", function() {
    // Rimuovere la classe 'selected' da tutti i bottoni delle taglie
    Array.from(sizeButtons).forEach(function(btn) {
      btn.classList.remove("selected");
    });

    // Aggiungere la classe 'selected' al bottone cliccato
    button.classList.add("selected");
  });
});