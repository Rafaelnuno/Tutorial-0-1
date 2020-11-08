window.onload = async function() {
    try {
    let res = await $.ajax({
    url: "/api/greeter",
    method: "get",
    dataType: "text"
    });
    document.getElementById("message").innerHTML = res;
    } catch (error) { console.log(error); }
   }