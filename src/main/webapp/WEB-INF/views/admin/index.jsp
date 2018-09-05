<%@ page session="true"%>
<html> welcome! </html>

<script>

    var num = Math.floor(Math.random()*100000);
    console.log(num);
    var numStr = num+"";
    console.log(numStr.length);
    for(i=0;i<numStr.length;i++){
        console.log(parseInt(num%10));
        num=num/10;
    }

</script>