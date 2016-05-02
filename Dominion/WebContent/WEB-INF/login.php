<?php
require_once "HTMLhead.php";
?>
<div class="login">
    <h1>Login</h1>
    <form method="post">
        <input type="text" name="u" placeholder="Username" required="required" />
        <input type="password" name="p" placeholder="Password" required="required" />
        <button type="submit" class="btn btn-primary btn-block btn-large">Let me in.</button>
        </br>
        <a class="btn" href="#">Register</a>
    </form>

</div>

<script src="js/index.js"></script>


<?php








require_once "HTMLtail.php";
?>