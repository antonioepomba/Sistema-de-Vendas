function test()
{
    var userId = document.getElementById("usuario");
    var pwd = document.getElementById("senha");

    var inputs = [userId, pwd];

    for(var i = 0; i < inputs.length; i++)
    {
        if(inputs[i].value == "")
        {
            inputs[i].style.border = "2px solid red";
            return false;
        }else
        {
            inputs[i].style.border = "2px solid green";
        }
    }


}