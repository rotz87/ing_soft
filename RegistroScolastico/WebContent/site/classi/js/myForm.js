function myForm()
{
	var assenze = document.getElementsByName("Assenza");
	for(var i=0;i<assenze.length;i++)
	{
		console.log(assenze[i].value + " premuto: " + assenze[i].checked);
	}
	return false;
}