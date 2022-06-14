<%@page import="java.util.List"%>
<%@page import="com.model.training_infoVO"%>
<%@page import="com.model.userid_training_listVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="font-size: 16px;">
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="Fitness &amp;amp; Yoga, ​Yoga for Relaxation, ​Gain balance, strength, and flexibility for your body and mind, Our training plan for complete beginners, ​Join Our Newsletter">
    <meta name="description" content="">
    <title>view_recom</title>
    <link rel="stylesheet" href="nicepage.css" media="screen">
    <link rel="stylesheet" href="exercise.css" media="screen">
    <link rel="stylesheet" href="view_recom.css" media="screen">
<link rel="stylesheet" href="view_recom.css" media="screen">
    <script class="u-script" type="text/javascript" src="jquery.js" defer=""></script>
    <!-- <script class="u-script" type="text/javascript" src="nicepage.js" defer=""></script> -->
    <meta name="generator" content="Nicepage 4.12.14, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,200i,300,300i,400,400i,600,600i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
    
    
    <script type="application/ld+json">{
		"@context": "http://schema.org",
		"@type": "Organization",
		"name": "",
		"logo": "images/male-silhouette-variant-showing-muscles.png"
}</script>
    <meta name="theme-color" content="#f67460">
    <meta property="og:title" content="view_recom">
    <meta property="og:type" content="website">
  </head>
  <body data-home-page="view_recom.html" data-home-page-title="view_recom" class="u-body u-xl-mode"><header class="u-clearfix u-header" id="sec-fdc6"><div class="u-clearfix u-sheet u-valign-middle-lg u-valign-middle-md u-valign-middle-sm u-valign-middle-xl u-sheet-1">
        <%
<<<<<<< HEAD
        //List<userid_training_listVO> vo = (List<userid_training_listVO>);
=======
        List<userid_training_listVO> vo = (List<userid_training_listVO>);
>>>>>>> branch 'master' of https://github.com/2022-SMHRD-KDT-BigData-6/kcTeamRepo.git
        //training_infoVO tvo = (training_infoVO)request.getAttribute("tvo");
        
        %>
        
        <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="512" data-image-height="512">
          <img src="images/male-silhouette-variant-showing-muscles.png" class="u-logo-image u-logo-image-1">
        </a>
        <h2 class="u-text u-text-default-xs u-text-1">오늘의 운동 추천</h2>
      </div></header>
    <section class="u-clearfix u-grey-10 u-section-1" id="sec-f395">
      <div class="u-clearfix u-sheet u-valign-middle-lg u-valign-middle-md u-valign-middle-sm u-valign-middle-xl u-sheet-1">
        <div class="u-expanded-width u-layout-horizontal u-list u-list-1">
          <div class="u-repeater u-repeater-1">
            <div class="u-align-center u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-1">
                <div alt="" class="u-image u-image-circle u-image-1" src="" data-image-width="512" data-image-height="512"></div>
                <h5 class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-1">
                </h5>
                <p class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-2"><input type="text" placeholder="" value="세트수" id="text-4500" name="set_val1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"><br>
                </p>
               <p class="u-align-center-xs u-text u-text-3"><input type="text" placeholder="" id="text-4500" value="개수" name="secncnt_val1" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></p> 
              </div>
            </div>
            <div class="u-align-center u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-2">
                <div alt="" class="u-image u-image-circle u-image-2" src="" data-image-width="512" data-image-height="512"></div>
                <h5 class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-4"><br>
                </h5>
                <p class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-5"><input type="text" placeholder="" id="text-4500" value="세트수" name="set_val2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"><br>
                </p>
                <p class="u-align-center-xs u-text u-text-6"><input type="text" placeholder="" id="text-4500" value="개수" name="secncnt_val2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></p>
              </div>
            </div>
            <div class="u-align-center u-container-style u-list-item u-repeater-item">
              <div class="u-container-layout u-similar-container u-valign-top-lg u-valign-top-md u-valign-top-sm u-valign-top-xl u-container-layout-3">
                <div alt="" class="u-image u-image-circle u-image-3" src="images/male-silhouette-variant-showing-muscles.png" data-image-width="512" data-image-height="512"></div>
                <h5 class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-7"></h5>
                <p class="u-align-center-lg u-align-center-md u-align-center-sm u-align-center-xs u-text u-text-8"><input type="text" placeholder="" id="text-4500" value="세트수" name="secncnt_val3" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></p>
                <p class="u-align-center-xs u-text u-text-9"><input type="text" placeholder="" id="text-4500" value="개수" name="secncnt_val2" class="u-border-1 u-border-grey-30 u-input u-input-rectangle u-white"></p>
              </div>
            </div>
          </div>
          <a class="u-absolute-vcenter-lg u-absolute-vcenter-md u-absolute-vcenter-sm u-absolute-vcenter-xl u-gallery-nav u-gallery-nav-prev u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-gallery-nav-1" href="#" role="button">
            <span aria-hidden="true">
              <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
            </span>
            <span class="sr-only">
              <svg viewBox="0 0 451.847 451.847"><path d="M97.141,225.92c0-8.095,3.091-16.192,9.259-22.366L300.689,9.27c12.359-12.359,32.397-12.359,44.751,0
c12.354,12.354,12.354,32.388,0,44.748L173.525,225.92l171.903,171.909c12.354,12.354,12.354,32.391,0,44.744
c-12.354,12.365-32.386,12.365-44.745,0l-194.29-194.281C100.226,242.115,97.141,234.018,97.141,225.92z"></path></svg>
            </span>
          </a>
          <a class="u-absolute-vcenter-lg u-absolute-vcenter-md u-absolute-vcenter-sm u-absolute-vcenter-xl u-gallery-nav u-gallery-nav-next u-grey-70 u-icon-circle u-opacity u-opacity-70 u-spacing-10 u-text-white u-gallery-nav-2" href="#" role="button">
            <span aria-hidden="true">
              <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
            </span>
            <span class="sr-only">
              <svg viewBox="0 0 451.846 451.847"><path d="M345.441,248.292L151.154,442.573c-12.359,12.365-32.397,12.365-44.75,0c-12.354-12.354-12.354-32.391,0-44.744
L278.318,225.92L106.409,54.017c-12.354-12.359-12.354-32.394,0-44.748c12.354-12.359,32.391-12.359,44.75,0l194.287,194.284
c6.177,6.18,9.262,14.271,9.262,22.366C354.708,234.018,351.617,242.115,345.441,248.292z"></path></svg>
            </span>
          </a>
        </div>
      </div>
    </section>
    
    
    <footer class="u-align-center u-clearfix u-footer u-grey-80 u-footer" id="sec-80dc"><div class="u-clearfix u-sheet u-sheet-1">
        <p class="u-small-text u-text u-text-variant u-text-1">Sample text. Click to select the text box. Click again or double click to start editing the text.</p>
      </div></footer>
    <section class="u-backlink u-clearfix u-grey-80">
      <a class="u-link" href="https://nicepage.com/templates" target="_blank">
        <span>Free Template</span>
      </a>
      <p class="u-text">
        <span>created with</span>
      </p>
      <a class="u-link" href="https://nicepage.cc" target="_blank">
        <span>Website Builder</span>
      </a>. 
    </section>
  </body>
</html>