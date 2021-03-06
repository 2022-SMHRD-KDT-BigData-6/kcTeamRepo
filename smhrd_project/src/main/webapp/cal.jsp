<%@page import="com.model.user_infoVO"%>
<%@page import="com.model.usertlVO"%>
<%@page import="com.model.memberTDAO"%>
<%@page import="org.apache.ibatis.reflection.SystemMetaObject"%>
<%@page import="com.model.userid_training_listVO"%>
<%@page import="java.util.List"%>
<%@page import="com.model.userid_training_listDAO"%>
<%@page import="com.model.training_infoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html style="font-size: 16px;">

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="utf-8">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <title>Contact</title>
    <link rel="stylesheet" href="Record.css" media="screen">
    
    <link rel="stylesheet" href="nicepage.css">
    <link rel="stylesheet" href="Page-1.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <meta name="generator" content="Nicepage 4.12.14, nicepage.com">
    <link id="u-theme-google-font" rel="stylesheet"
        href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">



    <script type="application/ld+json">
    {
      "@context": "http://schema.org",
      "@type": "Organization",
      "name": "",
      "logo": "images/default-logo.png"
    }
    </script>
    <meta name="theme-color" content="#478ac9">
    <meta property="og:title" content="Contact">
    <meta property="og:type" content="website">
</head>

<body class="u-body u-xl-mode">


    <header class="u-border-2 u-border-black u-border-no-left u-border-no-right u-border-no-top u-clearfix u-header u-header" id="sec-fdc6">
        
        <div class="u-clearfix u-sheet u-valign-middle-xs u-sheet-1">
            <a href="https://nicepage.com" class="u-image u-logo u-image-1" data-image-width="512" data-image-height="512">
              <img src="images/male-silhouette-variant-showing-muscles.png" class="u-logo-image u-logo-image-1">
            </a>
            <h2 class="u-text u-text-default-xs u-text-1">?????? ??????</h2>
          </div>
    </header>
   
        <div class="u-clearfix u-sheet u-sheet-1">

            <div class="sec_cal" style="border-bottom: 1px solid black;">
                <div class="cal_nav">
                    <a href="javascript:;" class="nav-btn go-prev">prev</a>
                    <div class="year-month"></div>
                    <a href="javascript:;" class="nav-btn go-next">next</a>
                </div>
                <div class="cal_wrap">
                    <div class="days">
                        <div class="day">MON</div>
                        <div class="day">TUE</div>
                        <div class="day">WED</div>
                        <div class="day">THU</div>
                        <div class="day">FRI</div>
                        <div class="day">SAT</div>
                        <div class="day">SUN</div>
                    </div>
                    <div class="dates">
                        <img src="" alt="">
                    </div>

                </div>

            </div>

            <section style="border-bottom: 1px solid black">
              <div>
                <div>
                  <a href="detail.jsp">
                    <div>
                      <div>
                        <div> 
                          <p>
                            1.
                          </p>
                        </div>
                      </div>
                      <div>
                        <div>
                          <p>
                            2.
                          </p>
                        </div>
                      </div>
                      <div>
                        <div> 
                          <p>
                            3.
                          </p>
                        </div>
                      </div>
                    </div>
                  </a>
                </div>
              </div>
            </section>
                 
            <script 
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" 
            crossorigin="anonymous">
            </script>
            
            
            <script>
                $(document).ready(function () {
                    calendarInit();
                });
                
                /*
                    ?????? ????????? ??? ??? ????????? ?????? ?????? 
                
                    ?????? ???(????????? : ?????? ??????)
                    ?????? ???????????? ????????? ??????
                    ?????? ???????????? ????????? ??????
                */

                function calendarInit() {

                    // ?????? ?????? ????????????
                    var date = new Date(); // ?????? ??????(?????? ??????) ????????????
                    var utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); // uct ????????? ??????
                    var kstGap = 9 * 60 * 60 * 1000; // ?????? kst ???????????? ?????????
                    var today = new Date(utc + kstGap); // ?????? ???????????? date ?????? ?????????(??????)

                    var thisMonth = new Date(today.getFullYear(), today.getMonth(), today.getDate());
                    // ???????????? ???????????? ?????? ??????


                    var currentYear = thisMonth.getFullYear(); // ???????????? ???????????? ???
                    var currentMonth = thisMonth.getMonth(); // ???????????? ???????????? ???
                    var currentDate = thisMonth.getDate(); // ???????????? ???????????? ???

                    // kst ?????? ????????????
                    // console.log(thisMonth);

                    // ????????? ?????????
                    renderCalender(thisMonth);

                    function renderCalender(thisMonth) {

                        // ???????????? ?????? ????????? ??????
                        currentYear = thisMonth.getFullYear();
                        currentMonth = thisMonth.getMonth();
                        currentDate = thisMonth.getDate();

                        // ?????? ?????? ????????? ??? ????????? ?????? ?????????
                        var startDay = new Date(currentYear, currentMonth, 0);
                        var prevDate = startDay.getDate();
                        var prevDay = startDay.getDay();

                        // ?????? ?????? ???????????? ????????? ?????? ?????????
                        var endDay = new Date(currentYear, currentMonth + 1, 0);
                        var nextDate = endDay.getDate();
                        var nextDay = endDay.getDay();

                        // console.log(prevDate, prevDay, nextDate, nextDay);

                        // ?????? ??? ??????
                        $('.year-month').text(currentYear + '.' + (currentMonth + 1));

                        // ????????? html ?????? ??????
                        calendar = document.querySelector('.dates')
                        calendar.innerHTML = '';


                      
                        // ?????????
                        for (var i = prevDate - prevDay + 1; i <= prevDate; i++) {
                            calendar.innerHTML = calendar.innerHTML + '<div class="day prev disable">' + i + '</div>'
                        }
                        
                        
                        // ?????????
                        for (var i = 1; i <= nextDate; i++) {
                            calendar.innerHTML = calendar.innerHTML + '<div id="this_month_day" class="day current">' + i + '</div>'

                        }
                       

                        // ?????????
                        for (var i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
                            calendar.innerHTML = calendar.innerHTML + '<div class="day next disable">' + i + '</div>'
                        }


                        // ?????? ?????? ??????
                        if (today.getMonth() == currentMonth) {
                            todayDate = today.getDate();
                            var currentMonthDate = document.querySelectorAll('.dates .current');
                            currentMonthDate[todayDate - 1].classList.add('today');
                        }
                        
                     // ?????? ???????????? ???
                        $('.day').click(function () {
                        // function
     
                        $(".day").removeClass("today");
                        $(this).removeClass("today").addClass("today");
                        $("u-repeater u-repeater-1").removeClass("u-repeater u-repeater-1");
                        
                       
                        let data2 = $("div.year-month").text();
                        data2 = data2.split('.');
                        let data = $(this).text();
                     let result = data2[0]+'/'+data2[1]+'/'+data;
                     
                     console.log(result)
                     
                        
                        //console.log(day_current_today[]);
                        // ???????????? src ????????? ????????? ?????? ?????? ?????? ?????????????????? ????????? ??? ???????????? ????????????
                        // src="./images/bar/Deadlift-2.jpg"
                        
                        //????????? ??? ?????? ???????????? ????????????(ajax)??? ???????????? cal.java????????? ????????? ??????
                        // cal.java??? ?????????????????? ????????? : result(??????)
                        // list --> json????????? ??????????????? ?????? ???????????? ?????????.
                        $.ajax({
                   // ????????? ????????? url
                      url : "cal",
                      type : "GET",
                      // ????????? ????????? ????????? ???????????? ???????????????
                      //"data =" ???????????? ??????
                      //data : "data="+data,
                      data : "data="+result,
                      // ????????? ???????????? ???????????? ????????????
                      dataType : 'json',
                      success : function(res) {
                         console.log(res);
                         
                         
                         //console.log('??????!');
                         // ????????? res?????? ???????????? ???????????? ????????? ??? ????????? 
                      
                      
                         if(res.length==0){
                            $('div:nth-child(1) > div > p').html('<span>'+"???????????????????????????."+'</span>')
                            $('div:nth-child(2) > div > p').html('<span>'+"???????????????????????????."+'</span>')
                            $('div:nth-child(3) > div > p').html('<span>'+"???????????????????????????."+'</span>')
                         }else{
                            $('div:nth-child(1) > div > p').html('<span>'+"???????????? : "+res[0].training_name+'<br>'+"?????? : "+ res[0].set_val+'<br>'+"?????? :"+res[0].secncnt_val+'</span>')        
                            $('div:nth-child(2) > div > p').html('<span>'+"???????????? : "+res[1].training_name+'<br>'+"?????? : "+ res[1].set_val+'<br>'+"?????? :"+res[1].secncnt_val+'</span>')        
                            $('div:nth-child(3) > div > p').html('<span>'+"???????????? : "+res[2].training_name+'<br>'+"?????? : "+ res[2].set_val+'<br>'+"?????? :"+res[2].secncnt_val+'</span>')        
                               
                         }
                         
                
                         
                   },
                      error : function() {
                      alert('????????????!');
                   }

                });

                        
                        });
                        

                        
                    }

                    // ???????????? ??????
                    $('.go-prev').on('click', function () {
                        thisMonth = new Date(currentYear, currentMonth - 1, 1);
                        renderCalender(thisMonth);
                    });

                    // ???????????? ??????
                    $('.go-next').on('click', function () {
                        thisMonth = new Date(currentYear, currentMonth + 1, 1);
                        renderCalender(thisMonth);
                        
                    });

                    
                    

            }

                



            </script>


<!-- Code injected by live-server -->
<script type="text/javascript">
   // <![CDATA[  <-- For SVG support
   if ('WebSocket' in window) {
      (function () {
         function refreshCSS() {
            var sheets = [].slice.call(document.getElementsByTagName("link"));
            var head = document.getElementsByTagName("head")[0];
            for (var i = 0; i < sheets.length; ++i) {
               var elem = sheets[i];
               var parent = elem.parentElement || head;
               parent.removeChild(elem);
               var rel = elem.rel;
               if (elem.href && typeof rel != "string" || rel.length == 0 || rel.toLowerCase() == "stylesheet") {
                  var url = elem.href.replace(/(&|\?)_cacheOverride=\d+/, '');
                  elem.href = url + (url.indexOf('?') >= 0 ? '&' : '?') + '_cacheOverride=' + (new Date().valueOf());
               }
               parent.appendChild(elem);
            }
         }
         var protocol = window.location.protocol === 'http:' ? 'ws://' : 'wss://';
         var address = protocol + window.location.host + window.location.pathname + '/ws';
         var socket = new WebSocket(address);
         socket.onmessage = function (msg) {
            if (msg.data == 'reload') window.location.reload();
            else if (msg.data == 'refreshcss') refreshCSS();
         };
         if (sessionStorage && !sessionStorage.getItem('IsThisFirstTime_Log_From_LiveServer')) {
            console.log('Live reload enabled.');
            sessionStorage.setItem('IsThisFirstTime_Log_From_LiveServer', true);
         }
      })();
   }
   else {
      console.error('Upgrade your browser. This Browser is NOT supported WebSocket for Live-Reloading.');
   }
   // ]]>
</script></body>

</html>