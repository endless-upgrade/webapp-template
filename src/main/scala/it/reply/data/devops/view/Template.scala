package it.reply.data.devops.view

import scala.xml.Node

object Template {

  def page(title:String,
           content:Seq[Node],
           url: String => String = identity _,
           head: Seq[Node] = Nil,
           scripts: Seq[String] = Seq.empty,
           defaultScripts: Seq[String] = Seq("/assets/js/jquery.min.js", "/assets/js/bootstrap.min.js")) = {

    <html lang="en">
      <head>
        <title>{ title }</title>
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
        <nav class="navbar navbar-default navbar-static-top navbar-inverse">
          <div class="container">
            <ul class="nav navbar-nav">
              <li class="active">
                <a href="/"><span class="glyphicon glyphicon-home"></span> Home</a>
              </li>
              <li>
                <a href="https://en.wikipedia.org/wiki/DevOps"><span class="glyphicon glyphicon-question-sign"></span> What is DevOps</a>
              </li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-info-sign"></span>  Project Docs <span class="caret"></span></a>
                <ul class="dropdown-menu" role="menu">
                  <li><a href="">System Architecture</a></li>
                  <li><a href="">Dev processes</a></li>
                  <li><a href="">Cloudera Cluster</a></li>
                  <li><a href="">Automated Tests</a></li>
                  <li class="divider"></li>
                  <li><a href="">Configuration Management</a></li>
                  <li><a href="">Continuous Integration</a></li>
                  <li><a href="">Continuous Testing</a></li>
                  <li><a href="">Infrastructure as a Code</a></li>
                  <li><a href="">Continuous Deployment</a></li>
                  <li><a href="">Continuous Delivery</a></li>
                  <li><a href="">Continuous Management</a></li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class="navbar-right">
                <a href="https://github.com/dpasqualiReply/DevOpsProduction">
                  <span class="glyphicon icon-github"></span> GitHub Repository</a>
              </li>
            </ul>
          </div>
        </nav>



        <div class="jumbotron text-center">
          <div class="container">
            <a href="/">
              <img src="/assets/img/movielens-logo-white.png"/>
            </a>
          </div>
        </div>

        <div class="row bottomPadding">

          <div class="col-md-12 container">

            { content }

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
