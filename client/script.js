document.getElementById('numberForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const number1 = document.getElementById('number1').value;
    const number2 = document.getElementById('number2').value;
    const number3 = document.getElementById('number3').value;
  
    axios.post('votre_url_de_destination', {
      number1: number1,
      number2: number2,
      number3: number3
    })
    .then(function (response) {
      console.log(response.data);
      // Traiter la réponse ici
    })
    .catch(function (error) {
      console.error(error);
      // Gérer les erreurs ici
    });
  });
  