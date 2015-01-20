var appelloFilters =  angular.module('appelloFilters',[]);
appelloFilters.filter('assente', function() {
	return function(input,arrayIdStudenti) {
		var output = {};
		for (var j = 0; j < arrayIdStudenti;j++)
		{
			//arrayStudenti[j] = $scope.appello.studenti[j].idStudente
			
			arrayIdStudenti[$scope.appello.studenti[j].idStudente] = {idStudente : $scope.appello.studenti[j].idStudente}
		}
		if (input) {
			for (var j = 0; j < input.length; j++)
			{
				var trovato = false
				var indiceStud = 0;
				for (var i = 0; i < arrayIdStudenti.length && trovato == false; i++) {
					if (arrayIdStudenti[i].idStudente == input[j]) {
						trovato = true 
						indiceStud = arrayIdStudenti[i].idStudente;
						output[indiceStud] = {idStudente: indiceStud, assenza : true};
					} 
					else {
						//trovato = false
					}
				}
			}
		}
		return output;
	};
});
appelloFilters.filter('boolAssenza',function(){
	return function (input)
	{
		var res;
		if (input)
		{ res = true;}
		else
		{
			res = false;
		}
		return res;
	}
})