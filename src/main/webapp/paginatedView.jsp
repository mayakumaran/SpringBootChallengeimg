
 <html>
 <style>

a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
    font-size: 22px;
}

 a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
}

 a:hover:not(.active) {background-color: #ddd;}
</style>

<center><h1>APLLICANTS LIST</h1></center>
 <div>
  <a href="http://localhost:8080/show/1">1</a>
  <a href="http://localhost:8080/show/2">2</a>
  <a href="http://localhost:8080/show/3" class=active>3</a>
  
</div>
 
 
 </html>