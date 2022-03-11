function myfunction() {
   	let input = document.getElementById("display");

	// input.addEventListener("keyup", (event) => {
	// 	// Number 13 is the "Enter" key on the keyboard
	// 	if (event.key === 13) {
	// 	  input.value = eval(input.value);
	// 	}
	// })
	console.log(typeof input);
   	try {
   	    const new_str = eval(input.value);
   	    input.value = new_str;
   	}
   	        
   	catch {
   	    alert("Enter valid value");
   	    input.value = "";
   	}   	        
}
