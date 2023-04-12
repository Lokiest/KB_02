// JS
alert("BBB");

//첫 번째 버튼이 클릭되었을 때 호출될 함수 만들기
function btn1Check(objTarget) {
	/*objTarget.target.style.backgroundColor = "red";
	objTarget.target.style.color = "white";*/
	
	document.querySelector("#btn1").style.fontSize = "30px";
	document.querySelector("#btn1").style.border = "3px solid blue";
	
}

function btnFun() {
	console.log("hungry");
}