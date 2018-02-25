package it.reply.data.devops.view

import scala.xml.Node

object TemplateNotFound {

  def page(url: String => String = identity _,
           head: Seq[Node] = Nil,
           scripts: Seq[String] = Seq.empty,
           defaultScripts: Seq[String] = Seq("/assets/js/jquery.min.js", "/assets/js/bootstrap.min.js")) = {

    <html lang="en">
      <head>
        <title>404 Page Not Found</title>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <meta name="description" content="DevOps POC" />
        <meta name="author" content="Dario Pasquali" />

        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
        <script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="/assets/css/main.css" />


        {head}
      </head>

      <body>

        <div class="row bottomPadding">

          <div class="col-md-12 container">
            
            <h1 class="error">404 Page Not Found. Feature non implementata :(</h1>

          </div>



        </div>
        <footer class="vcard" role="contentinfo">

        </footer>

        <!-- Le javascript
          ================================================== -->
        <!-- Placed at the end of the document so the pages load faster -->
        { (defaultScripts ++ scripts) map { pth =>
        <script type="text/javascript" src={pth}></script>
      } }

      </body>

    </html>
  }

}
