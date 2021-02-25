document.getElementById('b1').onclick = function() {
    showPrompt("input new value:)", function(value) {
      alert("Вы ввели: " + value);
    });