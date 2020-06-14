<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<html class="no-js"> 
 <meta http-equiv="content-type" content="text/html;charset=utf-8" />
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%-- <title><tiles:getAsString name="title" /></title> --%>
  <link href="<c:url value='/static/website/files/assets/frame.scsse01f.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/style9d84.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/slick-themec2a1.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/slick.scssc325.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/magnific-popup5b32.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/slick-slider5f89.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/frame.scsse01f.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/frame.scsse01f.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/frame.scsse01f.css' />" rel="stylesheet"></link>
  <link href="<c:url value='/static/website/files/assets/frame.scsse01f.css' />" rel="stylesheet"></link>
           
  
 <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto:300,300italic,400,600,400italic,600italic,700,700italic,800,800italic">
  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Roboto:300,300italic,400,600,400italic,600italic,700,700italic,800,800italic">
  <link rel="stylesheet" type="text/css" href="http://fonts.googleapis.com/css?family=Pacifico:300,300italic,400,600,400italic,600italic,700,700italic,800,800italic">
  <script>window.performance && window.performance.mark && window.performance.mark('shopify.content_for_header.start');</script><meta id="shopify-digital-wallet" name="shopify-digital-wallet" content="/2971009142/digital_wallets/dialog">
  <link href="https://monorail-edge.shopifysvc.com/" rel="dns-prefetch">
  <script id="shopify-features" type="application/json"></script>
  
 <script>var Shopify = Shopify || {};
Shopify.shop = "groceries-mart.myshopify.com";
Shopify.locale = "en";
Shopify.currency = {"active":"USD","rate":"1.0"};
Shopify.theme = {"name":"Gopher's Grocery (final)","id":79243804790,"theme_store_id":null,"role":"main"};
Shopify.theme.handle = "null";
Shopify.theme.style = {"id":null,"handle":null};</script>
<script type="module">!function(o){(o.Shopify=o.Shopify||{}).modules=!0}(window);</script>
<script>!function(o){function n(){var o=[];function n(){o.push(Array.prototype.slice.apply(arguments))}return n.q=o,n}var t=o.Shopify=o.Shopify||{};t.loadFeatures=n(),t.autoloadFeatures=n()}(window);</script>
<script>(function() {
  function asyncLoad() {
    var urls = [""];
    for (var i = 0; i < urls.length; i++) {
      var s = document.createElement('script');
      s.type = 'text/javascript';
      s.async = true;
      s.src = urls[i];
      var x = document.getElementsByTagName('script')[0];
      x.parentNode.insertBefore(s, x);
    }
  };
  if(window.attachEvent) {
    window.attachEvent('onload', asyncLoad);
  } else {
    window.addEventListener('load', asyncLoad, false);
  }
})();</script>
<script id="__st">var __st={"a":2971009142,"offset":-14400,"reqid":"bc834dc2-560c-473a-a497-477ea5c928d4","pageurl":"groceries-mart.myshopify.com\/","u":"f00c333133bb","p":"home"};</script>
<script>window.ShopifyPaypalV4VisibilityTracking = true;</script>
<script>window.ShopifyAnalytics = window.ShopifyAnalytics || {};
window.ShopifyAnalytics.meta = window.ShopifyAnalytics.meta || {};
window.ShopifyAnalytics.meta.currency = 'USD';
var meta = {"page":{"pageType":"home"}};
for (var attr in meta) {
  window.ShopifyAnalytics.meta[attr] = meta[attr];
}</script>
<script>window.ShopifyAnalytics.merchantGoogleAnalytics = function() {
  
};
</script>
<script class="analytics">(function () {
  var customDocumentWrite = function(content) {
    var jquery = null;

    if (window.jQuery) {
      jquery = window.jQuery;
    } else if (window.Checkout && window.Checkout.$) {
      jquery = window.Checkout.$;
    }

    if (jquery) {
      jquery('body').append(content);
    }
  };

  var isDuplicatedThankYouPageView = function() {
    return document.cookie.indexOf('loggedConversion=' + window.location.pathname) !== -1;
  }

  var setCookieIfThankYouPage = function() {
    if (window.location.pathname.indexOf('/checkouts') !== -1 &&
        window.location.pathname.indexOf('/thank_you') !== -1) {

      var twoMonthsFromNow = new Date(Date.now());
      twoMonthsFromNow.setMonth(twoMonthsFromNow.getMonth() + 2);

      document.cookie = 'loggedConversion=' + window.location.pathname + '; expires=' + twoMonthsFromNow;
    }
  }

  var trekkie = window.ShopifyAnalytics.lib = window.trekkie = window.trekkie || [];
  if (trekkie.integrations) {
    return;
  }
  trekkie.methods = [
    'identify',
    'page',
    'ready',
    'track',
    'trackForm',
    'trackLink'
  ];
  trekkie.factory = function(method) {
    return function() {
      var args = Array.prototype.slice.call(arguments);
      args.unshift(method);
      trekkie.push(args);
      return trekkie;
    };
  };
  for (var i = 0; i < trekkie.methods.length; i++) {
    var key = trekkie.methods[i];
    trekkie[key] = trekkie.factory(key);
  }
  trekkie.load = function(config) {
    trekkie.config = config;
    var script = document.createElement('script');
    script.type = 'text/javascript';
    script.onerror = function(e) {
      (new Image()).src = '';
    };
    script.async = true;
    script.src = '';
    var first = document.getElementsByTagName('script')[0];
    first.parentNode.insertBefore(script, first);
  };
  trekkie.load(
    {"Trekkie":{"appName":"storefront","development":false,"defaultAttributes":{"shopId":2971009142,"isMerchantRequest":null,"themeId":79243804790,"themeCityHash":"15944342948225883999","contentLanguage":"en","currency":"USD"},"isServerSideCookieWritingEnabled":false},"Performance":{"navigationTimingApiMeasurementsEnabled":true,"navigationTimingApiMeasurementsSampleRate":1},"Session Attribution":{}}
  );

  var loaded = false;
  trekkie.ready(function() {
    if (loaded) return;
    loaded = true;

    window.ShopifyAnalytics.lib = window.trekkie;
    

    var originalDocumentWrite = document.write;
    document.write = customDocumentWrite;
    try { window.ShopifyAnalytics.merchantGoogleAnalytics.call(this); } catch(error) {};
    document.write = originalDocumentWrite;
      (function () {
        if (window.BOOMR && (window.BOOMR.version || window.BOOMR.snippetExecuted)) {
          return;
        }
        window.BOOMR = window.BOOMR || {};
        window.BOOMR.snippetStart = new Date().getTime();
        window.BOOMR.snippetExecuted = true;
        window.BOOMR.snippetVersion = 12;
        window.BOOMR.application = "core";
        window.BOOMR.shopId = 2971009142;
        window.BOOMR.themeId = 79243804790;
        window.BOOMR.url =
          "https://cdn.shopify.com/shopifycloud/boomerang/shopify-boomerang-1.0.0.min.js";
        var where = document.currentScript || document.getElementsByTagName("script")[0];
        var parentNode = where.parentNode;
        var promoted = false;
        var LOADER_TIMEOUT = 3000;
        function promote() {
          if (promoted) {
            return;
          }
          var script = document.createElement("script");
          script.id = "boomr-scr-as";
          script.src = window.BOOMR.url;
          script.async = true;
          parentNode.appendChild(script);
          promoted = true;
        }
        function iframeLoader(wasFallback) {
          promoted = true;
          var dom, bootstrap, iframe, iframeStyle;
          var doc = document;
          var win = window;
          window.BOOMR.snippetMethod = wasFallback ? "if" : "i";
          bootstrap = function(parent, scriptId) {
            var script = doc.createElement("script");
            script.id = scriptId || "boomr-if-as";
            script.src = window.BOOMR.url;
            BOOMR_lstart = new Date().getTime();
            parent = parent || doc.body;
            parent.appendChild(script);
          };
          if (!window.addEventListener && window.attachEvent && navigator.userAgent.match(/MSIE [67]./)) {
            window.BOOMR.snippetMethod = "s";
            bootstrap(parentNode, "boomr-async");
            return;
          }
          iframe = document.createElement("IFRAME");
          iframe.src = "about:blank";
          iframe.title = "";
          iframe.role = "presentation";
          iframe.loading = "eager";
          iframeStyle = (iframe.frameElement || iframe).style;
          iframeStyle.width = 0;
          iframeStyle.height = 0;
          iframeStyle.border = 0;
          iframeStyle.display = "none";
          parentNode.appendChild(iframe);
          try {
            win = iframe.contentWindow;
            doc = win.document.open();
          } catch (e) {
            dom = document.domain;
            iframe.src = "javascript:var d=document.open();d.domain='" + dom + "';void(0);";
            win = iframe.contentWindow;
            doc = win.document.open();
          }
          if (dom) {
            doc._boomrl = function() {
              this.domain = dom;
              bootstrap();
            };
            doc.write("<body onload='document._boomrl();'>");
          } else {
            win._boomrl = function() {
              bootstrap();
            };
            if (win.addEventListener) {
              win.addEventListener("load", win._boomrl, false);
            } else if (win.attachEvent) {
              win.attachEvent("onload", win._boomrl);
            }
          }
          doc.close();
        }
        var link = document.createElement("link");
        if (link.relList &&
          typeof link.relList.supports === "function" &&
          link.relList.supports("preload") &&
          ("as" in link)) {
          window.BOOMR.snippetMethod = "p";
          link.href = window.BOOMR.url;
          link.rel = "preload";
          link.as = "script";
          link.addEventListener("load", promote);
          link.addEventListener("error", function() {
            iframeLoader(true);
          });
          setTimeout(function() {
            if (!promoted) {
              iframeLoader(true);
            }
          }, LOADER_TIMEOUT);
          BOOMR_lstart = new Date().getTime();
          parentNode.appendChild(link);
        } else {
          iframeLoader(false);
        }
        function boomerangSaveLoadTime(e) {
          window.BOOMR_onload = (e && e.timeStamp) || new Date().getTime();
        }
        if (window.addEventListener) {
          window.addEventListener("load", boomerangSaveLoadTime, false);
        } else if (window.attachEvent) {
          window.attachEvent("onload", boomerangSaveLoadTime);
        }
        if (document.addEventListener) {
          document.addEventListener("onBoomerangLoaded", function(e) {
            e.detail.BOOMR.init({
              ResourceTiming: {
                enabled: true,
                trackedResourceTypes: ["script"]
              },
            });
            e.detail.BOOMR.t_end = new Date().getTime();
          });
        } else if (document.attachEvent) {
          document.attachEvent("onpropertychange", function(e) {
            if (!e) e=event;
            if (e.propertyName === "onBoomerangLoaded") {
              e.detail.BOOMR.init({
                ResourceTiming: {
                  enabled: true,
                  trackedResourceTypes: ["script"]
                },
              });
              e.detail.BOOMR.t_end = new Date().getTime();
            }
          });
        }
      })();
    

    if (!isDuplicatedThankYouPageView()) {
      setCookieIfThankYouPage();
      
        window.ShopifyAnalytics.lib.page(
          null,
          {"pageType":"home"}
        );
      
      
    }
  });

  
      var eventsListenerScript = document.createElement('script');
      eventsListenerScript.async = true;
      eventsListenerScript.src = "https://cdn.shopify.com/s/assets/shop_events_listener-2c6237918c4bbec8783d8ceecd5759edc38afa9b5bef55134462710955517539.js";
      document.getElementsByTagName('head')[0].appendChild(eventsListenerScript);
    
})();</script>
<link href="<c:url value='/static/website/files/compiled_assets/styles0e01.css' />" rel="stylesheet"></link>
<script type="text/javascript" data-sections="slideshow,top-bar,home-sidebar-promoimage,home-sidebar-promoimage_2" defer="defer" src="<c:url value='/static/website/files/compiled_assets/scripts0e01.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/assets/header3214.js'/>"></script>
 <script>
    // Wait for window load
    $(window).load(function() {		
      var loader = $( '.se-pre-con' );
      if ( loader.length ) {
        $( window ).on( 'beforeunload', function() {
          loader.fadeIn( 500, function() {
            loader.children().fadeIn( 100 )
          });
        });
        loader.fadeOut(1500 );
        loader.children().fadeOut();
      }

    });
  </script>  
<style>
   /* Top block */
    .header-type-10 .top_bar { background: #605e5e; }
    .header-type-10 .top_bar li { color:#f7f7f7;}     
    .header-type-10 .top_bar a,.header-type-10 .top_bar button { color:#ffffff;}    
    .header-type-10 .top_bar a:hover, .header-type-10 .top_bar a:hover span,.header-type-10 .top_bar button:hover,.header-type-10 li.init.dt-sc-toggle:hover  { color:#fad400;}    

  
    .header-type-10 .header-top a.close { background: #84c225;color: #000000; }  
    .header-type-10 .header-top a.close:hover { background: #fad400;;color: #000000; }  
    .header-type-10 .header-top { background: ; }      
    .header-type-10 .header-top ul li { color: ; }    

   .notification_promobtn .btn {background:#fad400;color:#000000;border:none;}


    .notification_promobtn .btn:hover {background:#84c225;color:#fff;}
 /* Currency block */

    .header-type-10 .header_currency ul select,.header_currency ul li.currency .selector-arrow:after {color:#fff;}   
    .header-type-10 .header_currency ul select:hover,.header_currency ul li.currency .selector-arrow:hover:after {color:#fad400;}  
    .header-type-10 .header_currency ul li.currency:hover:after {border-top-color:#fad400;}
    .header-type-10 .header_currency ul li.currency:after,.header-type-10 li.init.dt-sc-toggle:after {color:#fff;}
    .header-type-10 .header_currency option {background:#fff;color:#000;}



</style>
</head>
<body id="gopher-39-s-grocery" class="template-index" >
<div class="wrapper-container">     
  <div class="header-type-10">
    <header class="site-header">
     <div id="shopify-section-top-bar" class="shopify-section">
    <div class="top_bar top-bar-type-10">    
  <div class="container">
    <ul class="top_bar_left">
     <li><i class="fa fa-phone"></i> (+91) 600 198 7297</li>
      <li><i class="fa fa-envelope"></i> <a href="mailto:support@onlinemarts.com"> support@onlinemarts.com</a></li>
    </ul>
    <ul class="top_bar_right">
     <li> <a href="#"> Store Location</a></li>
     <li><a href="#"> Track Your Order</a></li>
     <li class="header_currency">
        <ul class="tbl-list">                    
          <li class="currency dropdown-parent uppercase currency-block">    
<div class="selector-arrow">
<select class="currencies_src" id="currencies">
  <option data-currency="INR"  value="INR">INR</option> 
 <!--  <option data-currency="JPY"  value="JPY">JPY</option> 
  <option data-currency="CAD"  value="CAD">CAD</option> 
  <option data-currency="CNY"  value="CNY">CNY</option> 
  <option data-currency="AED"  value="AED">AED</option> 
  <option data-currency="RUB"  value="RUB">RUB</option> --> 
  
</select>
</div>
 </li>
 </ul>
    </li>        
   </ul>
  </div>
</div>  
	 </div>
<div class="header-sticky">
 <div id="header-landing" class="sticky-animate">
    <div id="shopify-section-header" class="shopify-section">
		<div class="grid--full site-header__menubar"> 
		  <div class="container">
		    <div class="menubar_inner">
		      <div class="header_top">
		       <h1 class="grid__item site-header__logo" itemscope itemtype="">
		         <a href="index.html" style="max-width: px;">
		              <img class="normal-logo" src="${pageContext.request.contextPath}/static/website/files/assets/logo1585.png?v=9673255575022813482" alt=" Gopher&#39;s Grocery" itemprop="logo">
		            </a>
				</h1>
		      </div>
<script type="text/javascript">
        $(".header-all--collections ul").on("click", ".init", function() {
          $(this).closest(".header-all--collections ul").children('li:not(.init)').toggle();
        });
		var allOptions = $(".header-all--collections ul").children('li:not(.init)');
        $(".header-all--collections ul").on("click", "li:not(.init)", function() {
          allOptions.removeClass('selected');
          $(this).addClass('selected');
          $(".header-all--collections ul").children('.init').html($(this).html());
          allOptions.toggle();
        });
$('.init').click(function() {
          if($('.init').hasClass('active')) {       
            $(this).removeClass('active');//.addClass('blue');
          }
          else{
            $(this).addClass('active');//.addClass('red');
          }
        });
</script>	   
<div class="slidersearch search-categories">
        <div class="search-categories-section">
          <div class="header-all--collections list-unstyled">
           <ul class="inline-list">
              <li class="init">All Categories</li>
              <li data-value="value 1"><a href="javascript:(0);">Vegetables</a></li>
              <li data-value="value 2"><a href="javascript:(0);">Fruits</a></li>
              <li data-value="value 3"><a href="javascript:(0);">Poultry</a></li>
              <li data-value="value 4"><a href="javascript:(0);">Snackes</a></li>
              <li data-value="value 5"><a href="javascript:(0);">Fresh Chicken</a></li>
              <li data-value="value 6"><a href="javascript:(0);">Turkey</a></li>
              <li data-value="value 7"><a href="javascript:(0);">Cold Drinks</a></li>
            </ul>
         </div>
       <div class="header-search medium--hide">
            <form action="" method="get" class="search-bar__table-cell search-bar__form" role="search">	
       <input type="text" id="search" name="q" value="" placeholder="Search..." aria-label="Search..." class="search-bar__input sb-search-input">
              <button class="sb-search-submit" type="submit" value=""><i class="fa fa-search"></i></button>
            </form>
		 </div>
        </div>
      </div>
   <div class="header-shipping-details">
        <div class="header-shipping-icons">
      <div class="ship-icon"><img src="${pageContext.request.contextPath}/static/website/img/icon-6_40x409782.png?v=1528784416" alt="FREE SHIPPING" title="FREE SHIPPING"></div>
        <div class="ship-detail">
            <h6>FREE SHIPPING</h6>
            <p>Deliver to door Condition Apply</p>
          </div>
         </div>
        <div class="header-shipping-icons">
         <div class="ship-icon"><img src="${pageContext.request.contextPath}/static/website/img/icon-3_40x40774b.png?v=1528784431" alt="BIG SAVING MONEY" title="BIG SAVING MONEY"></div>
          <div class="ship-detail">
            <h6>BIG SAVING MONEY</h6>
            <p>On Order Over $99</p>
          </div>
         </div>
      </div>   
      <ul class="menu_bar_right grid__item wide--two-sixths post-large--two-sixths">
        <li class="header-mobile">
          <div class="menu-block visible-phone"><!-- start Navigation Mobile  -->
            <div id="showLeftPush">
              <i class="icon-menu icons" aria-hidden="true">  </i>
            </div>
          </div><!-- end Navigation Mobile  --> 
        </li>  
          
        <li class="header-search wide--hide post-large--hide large--hide">
          <div class="header_toggle"><span class="zmdi zmdi-search"></span></div>
          <div class="slidersearch">
            <form action="javascript:(0);" method="get" class="search-bar__table-cell search-bar__form" role="search">
      <input type="hidden" name="type" value="product">  
              <input type="text" id="search" name="q" value="" placeholder="Search..." aria-label="Search..." class="search-bar__input sb-search-input">
              <button class="sb-search-submit res_btn" type="submit" value=""><i class="icon-magnifier"></i></button>
            </form>
          </div>
        </li>
         
           
        <li class="wishlist">            
          <a  href="javascript:(0);" title="Wishlist"><i class="icon-heart"></i></a>            
        </li>
         
           
        <li class="header-bar__module cart header_cart">
          <!-- Mini Cart Start -->
<div class="baskettop">
  <div class="wrapper-top-cart">
    <a href="javascript:void(0)" id="ToggleDown" class="icon-cart-arrow">
     
      <i class="icon-handbag icons" aria-hidden="true"></i>
      <div class="detail">
        <div id="cartCount"> 
          0
        </div>
      </div>
     
    
    </a> 
    <div id="slidedown-cart" style="display:none"> 
      <!--  <h3>Shopping cart</h3>-->
      <div class="no-items">
        <p>Your cart is currently empty!</p>
        <p class="text-continue"><a class="btn" href="javascript:void(0)">Continue shopping</a></p>
      </div>
      <div class="has-items">
        <ul class="mini-products-list">  
          
        </ul>
        <div class="summary">                
          <p class="total">
            <span class="label">Cart total :</span>
            <span class="price"><span class=money>$0.00</span></span> 
          </p>
        </div>
        <div class="actions">
          <button class="btn" onclick="window.location='cart.html'"><i class="icon-check"></i>Check Out</button>
          <button class="btn text-cart" onclick="javascript:(0);"><i class="icon-basket"></i>View Cart</button>
        </div>
      </div>
    </div>
  </div>
</div> 
<!-- End Top Header -->  
      </li> 
       <li class="customer_account"> 
          <div class="header-account_links">
            <ul> 
              <li>
                <a href="javascript:(0);" title="Log in" data-value="value 1"><i class="icon-user icons"></i></a>
              </li>
			</ul>   
		</div>
		</li>
      </ul>
      
 </div>
</div>
</div>
<style> 

  
   
    /* Logo block */
    .header-type-10 .site-header__menubar { background: #84c225;}    
    .header-type-10 .site-header__logo a { color:#ffffff;}
    .header-type-10 .site-header__logo a:hover { color:#000;}    

    /* Menu  block */
    .header-type-10 .menubar-section,.mobile-nav-section {background: #ffffff;}
    .header-type-10 .menu-tool ul li {color: ;}
    .header-type-10 .menu-tool ul li a,.mobile-nav-section .mobile-nav-trigger {color:#000000;}  
    .header-type-10 .menu-tool ul li a:hover,.header-type-10 .menu-tool .site-nav > li > a.current:hover {color:#84c225;} 
    .header-type-10 .menu-tool .site-nav >  li > a.current {color:#84c225;} 
    .header-type-10 .site-nav-dropdown,#MobileNav,.mobile-nav__sublist { background: #fff;}
    .header-type-10 .site-nav-dropdown .inner > a {color: #000;}    
    .header-type-10 .site-nav-dropdown .inner > a:hover {color: #84c225;}    
    .header-type-10 .site-nav-dropdown .inner .dropdown a,.header-type-10 .menu-tool .site-nav .site-nav-dropdown li a,.header-type-10 .site-nav .widget-featured-product .product-title,.header-type-10 .site-nav .widget-featured-product .widget-title h3,#MobileNav a,.mobile-nav__sublist a,.site-nav .widget-featured-nav .owl-prev a,.site-nav .widget-featured-nav .owl-next a  {color: #000;}
    .header-type-10 .site-nav-dropdown .inner .dropdown a:hover,.header-type-10 .menu-tool .site-nav .site-nav-dropdown li a:hover,.header-type-10 .site-nav-dropdown .inner .dropdown a.current,.header-type-10 .menu-tool .site-nav .site-nav-dropdown li a.current,.header-type-10 .site-nav .widget-featured-product .product-title:hover,#MobileNav a.current,.mobile-nav__sublist a.current,.site-nav .widget-featured-nav .owl-prev a:hover,.site-nav .widget-featured-nav .owl-next a:hover {color: #84c225;}    
    /* Dropdown block */
    .header-type-10 .menubar-section #Togglemodal i {color: ;}
    .header-type-10 .menubar-section #Togglemodal i:hover {color: ;}
    .header-type-10 #slidedown-modal {background: ;}
    .header-type-10 #slidedown-modal ul li a {color:;} 
    .header-type-10 #slidedown-modal ul li a:hover {color:;} 


    /* Search block */     
    .header-type-10 .header-search input#search {color:#000;background:#fff;} 
    .header-type-10 .header-search span, .header-type-10 .header-search .res_btn,.header-mobile #showLeftPush  {color:#ffffff;background:none;} 
    .header-type-10 .header-search span:hover, .header-type-10 .header-search .res_btn:hover,.header-mobile #showLeftPush:hover {color:#000;background:none;} 
    .header-type-10 .header-search button { color:#000000;background:#fad400;} 
    .header-type-10 .header-search button:hover { color:#f7f7f7;background:#000000;} 
    .header-type-10 .header-all--collections { background:#fff;color:#000;}
    .header-type-10 .header-all--collections ul li a { color:#000; }
    .header-type-10 .header-search input#search::-webkit-input-placeholder  { /* Chrome/Opera/Safari */
      color:#000;
    }
    .header-type-10 .header-search input#search::-moz-placeholder { /* Firefox 19+ */
      color:#000;
    }
    .header-type-10 .header-search input#search:-ms-input-placeholder { /* IE 10+ */
      color:#000;
    }
    .header-type-10 .header-search input#search:-moz-placeholder { /* Firefox 18- */
      color:#000;
    }

    /* Cart Summary block */
    .header-type-10 .header-bar__module.cart .baskettop a.icon-cart-arrow #cartCount  {color: #000;background:#fad400;}
    .header-type-10 .header-bar__module.cart .baskettop a.icon-cart-arrow:hover #cartCount  {color: #fff;background:#000;}

    .header-type-10 #slidedown-cart .actions, .header-type-10  #slidedown-cart  {background: #fff;}
    .header-type-10 .header-bar__module p {color: #000000;}
    .header-type-10 .header-bar__module a {color:#000000;}  
    .header-type-10 .header-bar__module a:hover {color:#84c225;} 
    .header-type-10 .header-bar__module .btn {color:#ffffff;background: #84c225;} 
    .header-type-10 .header-bar__module .btn:hover {color:#ffffff;background: #000000;} 
    .header-type-10  #slidedown-cart .total .price, .header-type-10 #minicart_total,.header-type-10 #slidedown-cart ul li .cart-collateral {color:#000;} 
    .header-type-10 #slidedown-cart li { border-bottom:1px solid #e4e4e4; }


   
    /* Header borders */
    
    .header-type-10 .top_bar ul li:last-child,.header-type-10 .top_bar li:last-child span,.header-type-10 .top_bar li:last-child a { border-right:none; }

    .header-all--collections ul { 
      height: 30px;
      width: 100%;float:left;

    }
    .header-shipping-icons .ship-detail h6  {color:#ffffff;}

    .header-shipping-icons .ship-detail p {color:#f7f7f7;}
     .header-type-10 .header-all--collections { background:#fff;color:#000;}
    .header-type-10 .header-all--collections ul li a { color:#000; }
    .header-all--collections ul li { padding: 5px 10px; z-index: 2; }

    .header-all--collections li.init { cursor: pointer; }

    .header-account_links ul li { z-index: 2; }
    .header-account_links li.init { cursor: pointer; }
    .header-type-10 .dt-sc-toggle-content { background: #fff; }
    .header-type-10 .dt-sc-toggle-content.header-account_links ul li a { color:#000; }
    .header-type-10 .dt-sc-toggle-content.header-account_links ul li a:hover { color:#84c225; }


    /* wishlist */

    .header-type-10 .wishlist a,.header-type-10 .header-bar__module.cart .baskettop a.icon-cart-arrow,.header-type-10 .wishlist a, .customer_account ul li a { color:#ffffff; }
    .header-type-10 .wishlist a:hover,.header-type-10 .header-bar__module.cart .baskettop a.icon-cart-arrow:hover, .customer_account ul li a:hover {color:#000; } 
    .header-type-10 .is-sticky .wishlist a,.header-type-10 .is-sticky  .header-bar__module.cart .baskettop a.icon-cart-arrow { color:#000000; }
    .header-type-10 .is-sticky .wishlist a:hover,.header-type-10 .is-sticky  .header-bar__module.cart .baskettop a.icon-cart-arrow:hover {color:#84c225; } }

    
    /* General styles for all menus */
  
  
  .gf-menu-device-wrapper .close-menu {
    font-size: 17px;
    padding: 12px 20px;
    text-align: right;
    display: block;
}
  
.cbp-spmenu {
	
	position: fixed;
}

.cbp-spmenu h3 {
	
	font-size: 1.9em;
	padding: 20px;
	margin: 0;
	font-weight: 300;
	
}

.cbp-spmenu a {
	display: block;
	
	font-size: 1.1em;
	font-weight: 300;
}




/* Orientation-dependent styles for the content of the menu */

.cbp-spmenu-vertical {
	width: 240px;
	height: 100%;
	top: 0;
	z-index: 1000;
}

.cbp-spmenu-vertical a {
	
	padding: 1em;
}

.cbp-spmenu-horizontal {
	width: 100%;
	height: 150px;
	left: 0;
	z-index: 1000;
	overflow: hidden;
}

.cbp-spmenu-horizontal h3 {
	height: 100%;
	width: 20%;
	float: left;
}

.cbp-spmenu-horizontal a {
	float: left;
	width: 20%;
	padding: 0.8em;
	
}

/* Vertical menu that slides from the left or right */

.cbp-spmenu-left {
	left: -240px;
}

.cbp-spmenu-right {
	right: -240px;
}

.cbp-spmenu-left.cbp-spmenu-open {
	left: 0px;
}

.cbp-spmenu-right.cbp-spmenu-open {
	right: 0px;
}

/* Horizontal menu that slides from the top or bottom */

.cbp-spmenu-top {
	top: -150px;
}

.cbp-spmenu-bottom {
	bottom: -150px;
}

.cbp-spmenu-top.cbp-spmenu-open {
	top: 0px;
}

.cbp-spmenu-bottom.cbp-spmenu-open {
	bottom: 0px;
}

/* Push classes applied to the body */

.cbp-spmenu-push {
	overflow-x: hidden;
	position: relative;
	left: 0;
}

.cbp-spmenu-push-toright {
	left: 240px;
}

.cbp-spmenu-push-toleft {
	left: -240px;
}

/* Transitions */

.cbp-spmenu,
.cbp-spmenu-push {
	-webkit-transition: all 0.3s ease;
	-moz-transition: all 0.3s ease;
	transition: all 0.3s ease;
}

/* Example media queries */

@media screen and (max-width: 55.1875em){

	.cbp-spmenu-horizontal {
		font-size: 75%;
		height: 110px;
	}

	.cbp-spmenu-top {
		top: -110px;
	}

	.cbp-spmenu-bottom {
		bottom: -110px;
	}

}

@media screen and (max-height: 26.375em){

	.cbp-spmenu-vertical {
		font-size: 90%;
		width: 190px;
	}

	.cbp-spmenu-left,
	.cbp-spmenu-push-toleft {
		left: -190px;
	}

	.cbp-spmenu-right {
		right: -190px;
	}

	.cbp-spmenu-push-toright {
		left: 190px;
	}
}

  
  
  



/* width: 750px  */
@media (min-width: 968) and (max-width: 991px) {
  .banner .container { margin-left: -375px; }
  .banner .inner { width: 320px; }
  
  .header-bottom.on .header-panel-top { right: 65px; }
  .header-bottom.on .site-nav { padding-right: 90px; }
  
  .nav-bar .header-logo-fix { margin-left: 10px; margin-right: 10px; }
  .site-nav > li > a { margin-left: 12px; margin-right: 12px; }
  .header-bottom.on .site-nav > li > a { margin-left: 7px; margin-right: 7px; font-size: 10px; }
  
}

@media (min-width: 968px) {
  .cbp-spmenu-push-toright {left:0!important;}
  #cbp-spmenu-s1 {display: none !important;}
  
  
  .header-bottom.on .nav-bar .header-logo-fix { display: table; height: 48px; position: relative; z-index: 2; }
  .header-bottom.on .nav-bar .header-logo-fix a { display: table-cell; vertical-align: middle; }
  .header-bottom.on .site-nav { padding-right: 120px; }  
  .have-fixed .nav-bar {position: fixed;left: 0;right: 0;top: 0;z-index: 99;padding: 0;}
  .have-fixed .nav-search {position: fixed;top: 0;right: 65px;z-index: 100;width:52px;}
  
  
}

/* width: 100%  */
@media (max-width: 767px) {
  body.cbp-spmenu-push-toright {
  cursor: pointer;
}
  
  .cbp-spmenu .site-nav-dropdown.style_4 .inner img{margin-top:10px;}
 
 
  .visible-phone { display: block; }
  .hidden-phone { display: none; }
  
  /* header */




  
  /* Fix Menu Mobile */
  .nav-bar { display: none; }
  .gf-menu-device-container .site-nav { display: block!important; overflow: hidden;width:100%; }
  .gf-menu-device-container .site-nav li { width:100%; }
  .gf-menu-device-container .site-nav.gf-menu.clicked { visibility: visible; height: auto; }  
  /* End Fix Menu Mobile */

  .cbp-spmenu-left.cbp-spmenu-open { left: 0; overflow-y: auto; }
  .cbp-spmenu-push-toright {  overflow-y: hidden;position: fixed; width: 100%;}
  
  #megamenu-responsive-root { display: none !important; }
  .menu-block { width: 100%; float: none; padding: 0; }

  /* Icon Menu */
  .site-nav > li:hover > a > span:first-child, 
  .site-nav > li:hover > a.current > span:first-child, 
  .site-nav > li > a.current > span:first-child { border: 0; }
  .site-nav a { white-space: normal; }
  .cbp-spmenu {  }
  .cbp-spmenu .site-nav > li > a { font-size: 13px;   padding: 12px 20px; margin: 0; }

  .cbp-spmenu .site-nav > li.dropdown.open > a {position: relative;}
  .cbp-spmenu .site-nav > li.dropdown.open > a:before {top: 15px; }

  .menu-block .site-nav { border-bottom: none; }

  .site-nav li { position: relative; }
  .site-nav li.dropdown { position: relative; }
  .site-nav > li { display: block; clear: both; position: relative;}
  .site-nav > li > a { padding: 12px 0; }
  .site-nav > li.dropdown > p.toogleClick { height:0; width:0; display:block; margin-left: 7px; top: 2px; right: 5px; margin:0; padding: 0; z-index: 2; padding: 20px;}
  .site-nav > li.dropdown p.toogleClick { position: absolute; right: 0; text-indent: -999em; cursor: pointer; }
  .site-nav > li.dropdown > p.toogleClick.mobile-toggle-open:before { border-top-color:transparent; top: 14px;}
  
  .site-nav li.dropdown a > .icon-dropdown { display: none; }
  
  .site-nav-dropdown .container { padding-left: 0; padding-right: 0; }
  .site-nav-dropdown .row{margin:0px!important}
  

  .site-nav > li.dropdown ul p.toogleClick.mobile-toggle-open:before { top: 10px; }
  .site-nav-dropdown .col-1 .inner p.toogleClick:before,
  .site-nav > li.dropdown ul p.toogleClick:before { display: block; content:""; position: absolute; right: 0; top: -15px!important; width: 20px; height: 40px; }
  .site-nav-dropdown p.toogleClick { background: url(../cdn.shopify.com/s/files/1/0029/7100/9142/t/3/assets/icon-megamenu0e01.html?285) no-repeat; padding: 0; width: 8px; height: 8px; right: 0; top: 18px; z-index: 2; }
  .site-nav-dropdown .col-1 .inner p.toogleClick { display: block!important; }
  .site-nav > li.dropdown ul p.toogleClick.mobile-toggle-open,
  .site-nav-dropdown .col-1 .inner p.toogleClick.mobile-toggle-open { background-position: center bottom; height: 4px; }
  
  .site-nav > li > ul > .dropdown.open > ul {display: block;}
  .site-nav > li > ul > li > ul > .dropdown.open > ul {display: block;}
  .site-nav > li > ul > li > ul > ul > li > .dropdown.open > ul {display: block;}
    
  .site-nav > li > .site-nav-dropdown {}
  .site-nav > li > .site-nav-dropdown > li > a { padding: 11px 0 13px; text-transform: uppercase; font-size: 11px; font-weight: 700;  }
  .site-nav > li > .site-nav-dropdown > li:first-child > a { border-top: 0; }
  .site-nav > li > .site-nav-dropdown > li:hover > a:before { background: none; }
  .site-nav > li li .site-nav-dropdown { padding: 0 15px; margin-bottom: 20px; }
  .site-nav-dropdown li:hover a { background: none; }
  .site-nav-dropdown li:hover a, 
  .site-nav-dropdown a:active { padding-left: 0; }
  
  .site-nav-dropdown li li a { padding: 7px 0; }
  .site-nav-dropdown li li:hover a { padding: 7px 20px; }
  .site-nav-dropdown li:hover > a:before { left: 0; }
  
  .site-nav-dropdown .col-1,
  .site-nav-dropdown .col-2,
  .site-nav-dropdown .col-3 { width: 100%; padding: 0; }
  .site-nav-dropdown .col-3 { padding-bottom: 28px; }
  .site-nav-dropdown .col-1 .inner { width: 100%; padding: 0; }
  .cbp-spmenu .site-nav-dropdown .col-1 .inner:first-child > a { border-top: 0; }
  .site-nav-dropdown .col-1 ul.dropdown li a { padding: 7px 15px; font-size: 12px; font-weight: 400; text-transform: none; border: 0; }
  .site-nav-dropdown .col-1 ul.dropdown li:hover > a:before { left: 20px; }
  .site-nav .widget-featured-product { text-align: left;border-width: 1px 0; margin-bottom: 10px; padding-top: 23px; padding-bottom: 25px; padding-left:10px;}
  .site-nav .products-grid .grid-item { text-align: left; }
  .site-nav .products-grid .grid-item .product-grid-image { float: left; margin: 0 15px 0 0; }
  .widget-featured-product .grid-item .product-grid-image img { width: 80px; }
  .widget-featured-product .products-grid .grid-item { position: relative; }
  .widget-featured-product .details { overflow: hidden; }
  .site-nav .product-label { display: none; }
  .site-nav .product-label strong { float: left; }
  
  .cbp-spmenu .site-nav-dropdown .col-1 .inner { width: 100%!important; position: relative; padding: 0; float: left; }
  .cbp-spmenu .site-nav-dropdown.style_4 .inner{width:100%;}
 
  /*Update 2.0.1*/
  .site-nav-dropdown .col-2 .col-left { width: 100%; clear: both; padding: 0; }
  .site-nav-dropdown .col-2 .col-right { width: 100%; clear: both; padding: 0 0 10px; }
  .site-nav-dropdown .style_2 .col-2 .col-left a { padding-right: 0; }
  .site-nav-dropdown .style_3 .inner > img { display: none; }
  .site-nav-dropdown .style_4 .col-2 { padding-right: 0; }

}
.header-mobile { position: relative; }
.header-mobile #showLeftPush.active .fa-times{display:block;line-height:46px;}
.header-mobile #showLeftPush {display: block;font-size: 24px; text-align: center;  cursor: pointer; }
.header-mobile #showLeftPush.active,
.header-mobile #showLeftPush:hover {  }
.header-mobile .customer-area { float: left; width: 50%; position: static; }
.header-mobile .customer-area > a { float: left; width: 100%; height:46px;}
.header-mobile .customer-links { margin: 0; }
.header-mobile .dropdown-menu { font-size:12px; margin: 0; width: 200%; padding: 10px 15px; 
-webkit-border-radius: 0; -moz-border-radius: 0; border-radius: 0; 
-webkit-box-shadow: none; -moz-box-shadow: none; box-shadow: none; }
.header-mobile .dropdown-menu ul { overflow: hidden; margin: 0 0 10px; padding-left: 0; list-style: none; }
.header-mobile .customer-area .fa-user{display: block;text-align: center;line-height: 46px;font-size: 20px;}
</style> 
</div>
<div id="shopify-section-navigation" class="shopify-section"><div class="desktop-megamenu">
  <div class="nav-bar-mobile">
   <nav class="nav-bar" role="navigation">
      <div class="site-nav-dropdown_inner grid__item menubar-section">
        <div class="menu-tool">  
  			<ul class="site-nav">
  			<li class=" "><a  href="index.html" class="current"> <span>  Home </span></a> </li>
  			 <li class=" dropdown  mega-menu"><a  href="collections.html" class=""><span>Collection</span></a>
  			 <div class="site-nav-dropdown">     
 				<div class="container   style_5"> 
      				<div class="col-1 parent-mega-menu">        
			        	<div class="inner col-xs-12 col-sm-4">
					          <!-- Menu level 2 -->
					          <a  href="collections/new-arrival.html" class=" "></a>
					          <ul class="dropdown"><li>
					              <a href="javascript:(0);" >Apple</a></li>
					            <li><a href="javascript:(0);" > Mango</a></li>
					            <li><a href="javascript:(0);" > Banana</a></li>
					            <li><a href="javascript:(0);" >Orange</a></li>
					            <li><a href="javascript:(0);" >Grapes</a></li>
					           </ul>
					        </div>
					        <div class="inner col-xs-12 col-sm-4">
					         <a  href="javascript:(0);" class=" ">Fresh Meat</a>
					          <ul class="dropdown">
					          <li><a href="javascript:(0);" >Chicken</a></li>
					            <li><a href="javascript:(0);" >Meat</a></li>
					            <li><a href="javascript:(0);" >Prawn</a></li>
					            <li><a href="javascript:(0);" > Fish</a></li>
					           <li><a href="javascript:(0);" >Beef</a></li></ul>
					         </div>
					        
					        <div class="inner col-xs-12 col-sm-4">
					          <!-- Menu level 2 -->
					          <a  href="javascript:(0);" class=" ">
					            Kitchen Accessories 
					            
					          </a>
					          
					          <ul class="dropdown">
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Belan Stand
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Canister Set
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Water Purifier
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Gas Stove
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Chimney
					              </a>
					            </li>
					            
					          </ul>
					          
					        </div>
					        
					        <div class="inner col-xs-12 col-sm-4">
					          <!-- Menu level 2 -->
					          <a  href="javascript:(0);" class=" ">
					            Dhals 
					            
					          </a>
					          
					          <ul class="dropdown">
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Chana Dal
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Red Rajma
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Moong Green 
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Tur Dal
					              </a>
					            </li>
					            
					            <!-- Menu level 3 -->
					            <li>
					              <a href="javascript:(0);" >
					                Moong Whole
					              </a>
            </li>
          
          </ul>
          
        </div>
        
     </div>
            
            
      <div class="col-wide">
        
        <div class="bottom_left">          
          <a href="#" title="">
            <img src="${pageContext.request.contextPath}/static/website/img/mega-menu-3-1_2000xa540.jpg?v=1531743154" alt="" />
          </a>
        </div>
        
        
        <div class="bottom_right">          
          <a href="#" title="">
            <img src="${pageContext.request.contextPath}/static/website/img/mega-menu-3-2_2000x2d46.jpg?v=1531743166" alt="" />
          </a>
        </div>
        
      </div>      
      
      
    </div>
</div> 
  			 
  			  </li>	
  			  
  			  <li class=""><a  href="javascript:(0);" class=""><span> Shop</span></a></li>  
  			  <li class=" dropdown  mega-menu">
			      <a  href="javascript:(0);" class=""><span> Groceries </span> </a>
				  <div class="site-nav-dropdown">     
					<div class="container   style_2"> 
						<div class="col-1 parent-mega-menu">        
						<div class="inner col-xs-12 col-sm-4">
							<a  href="javascript:(0);" class=" ">Dariy</a>
								<ul class="dropdown"> <li><a href="javascript:(0);" >Toned Milk</a></li>
								<li><a href="javascript:(0);" >Paneer</a></li>
								</ul>
						</div>
						<div class="inner col-xs-12 col-sm-4">
						<!-- Menu level 2 -->
					          <a  href="javascript:(0);" class=" "> Desserts </a>
					          <ul class="dropdown">
					            <li><a href="javascript:(0);" >Sugar free</a></li>
					            <li><a href="javascript:(0);" >Honey</a></li>
					          </ul>
			        	</div>
			        	 <li class=" dropdown  mega-menu">
      <a  href="javascript:(0);" class="">
        <span>         
          Vegetables          
        </span>       
      </a> 	
<div class="site-nav-dropdown">     
 <div class="container   style_1"> 
      <div class="col-1 parent-mega-menu">        
        
        <div class="inner col-xs-12 col-sm-4">
          <!-- Menu level 2 -->
          <a  href="javascript:(0);" class=" ">
            Green leaves 
            
          </a>
          
          <ul class="dropdown">
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Lettuce
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Mint
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Pak Choi
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Banana Stem
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Coriander
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Spring Onion
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Amaranthus
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Palak
              </a>
            </li>
            
          </ul>
          
        </div>
        
        <div class="inner col-xs-12 col-sm-4">
          <!-- Menu level 2 -->
          <a  href="javascript:(0);" class=" ">
            Herbs  
            
          </a>
          
          <ul class="dropdown">
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Lemon
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Ginger
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Curry Leaves
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Fresh Garlic
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Chilli
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Pea Eggplant 
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Raw Mango
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Parsley Leaves
              </a>
            </li>
            
          </ul>
          
        </div>
        
        <div class="inner col-xs-12 col-sm-4">
          <!-- Menu level 2 -->
          <a  href="javascript:(0);" class=" ">
            Cuts & Sprouts  
            
          </a>
          
          <ul class="dropdown">
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Tender Coconut 
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Slim Milk 
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Green Peas
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Pomegranate
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Pineapple
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Sambar Onion
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Papaya
              </a>
            </li>
            
            <!-- Menu level 3 -->
            <li>
              <a href="javascript:(0);" >
                Coconut
              </a>
            </li>
            
          </ul>
          
        </div>
        
     </div>
<div class="col-2">
       <a href="#" title="">
            <img src="${pageContext.request.contextPath}/static/website/img/mega-menu-1_2000x8912.jpg?v=1531743098" alt="" />
          </a>
       </div>
   </div>
</div>                     
 </li>
 <li class="  dropdown">
      <a class="menu__moblie"  href="javascript:(0);" class="">
        <span>         
          Pages          
        </span>       
      </a> 	
<ul class="site-nav-dropdown">
  
  <li >                    
    <a href="javascript:(0);" class=""> <span>About Us</span> </a>
    <ul class="site-nav-dropdown">
    </ul>
  </li>
  
  <li >                    
    <a href="javascript:(0);" class="">               
      <span>               
        Contact Us                
      </span>
      
    </a>
    <ul class="site-nav-dropdown">
      
    </ul>
  </li>
  
  <li >                    
    <a href="javascript:(0);" class="">               
      <span>               
        Blog                
      </span>
      
    </a>
    <ul class="site-nav-dropdown">
      
    </ul>
  </li>
  
</ul>
</li>
</div>
  				</div>
  				</div>
  				</li>
  					
  			</ul>
  		</div>
  	</div>
  	</nav>
  </div>
  </div>



</div>
</div>
</header>
  
   	<!-- <div class="se-pre-con"></div> 
  	<div id="PageContainer"></div>   
  	<div class="quick-view"></div>     
    <div class="dt-sc-hr-invisible-small"></div> -->
  
  <div class="dt-sc-hr-invisible-small"></div>
	<main class="main-content" style=" margin-top: -10px;"> 
      <div class="container">
        <div class="grid-uniform position-change"> 
<div class="grid__item wide--one-sixth post-large--two-tenths first">
            <div class="homepage_sidebar left-sidebar">
              <div id="shopify-section-home-sidebar-category" class="shopify-section">
       				<div data-section-id="home-sidebar-category"  data-section-type="home-sidebar-category"> 
					  <div class="widget widget_product_categories"  style ="background:#fff">
					    
					    <h4><span>Categories</span></h4> 
					    <ul class="product-categories dt-sc-toggle-frame-set">
					       <li class="cat-item cat-item-39 cat-parent">
					          <i></i><a class=" " href="products/carrots.html">Fresh Vegetables</a> 
					        </li>
      <!--  <li class="cat-item cat-item-39 cat-parent first">
          <i></i>
          <a class="" href="products/dry-fruits.html">Snackes</a> <span class="dt-sc-toggle"></span>
		 <ul class="children dt-sc-toggle-content ">
            <li class="second">
              <i></i>             
              <a class="" href="collections/demand-product.html">Cookies</a>
              </li>
            <li class="second">
              <i></i>             
              <a class="" href="products/garlic.html">Cream biscuit</a>
             </li>
            <li class="second">
              <i></i>             
              <a class="" href="products/mushroom-button.html">Oats</a>
             </li>
           </ul>
          
        </li> -->
       <li class="cat-item cat-item-39 cat-parent first">
          <i></i>
          <a class="" href="javascript:(0);">Fruits</a> <span class="dt-sc-toggle"></span>
			<!--  <ul class="children dt-sc-toggle-content ">
            
               
            <li class="second">
              <i></i>             
              <a class="" href="products/dry-fruits.html">Apple</a>
            </li>
            <li class="second">
              <i></i>             
              <a class="" href="products/chicken-breast.html">Pineapple</a>
             </li>
            <li class="second">
              <i></i>             
              <a class="" href="products/chicken-breast.html">Grapes</a></li>
             </ul> -->
        </li>
        <li class="cat-item cat-item-39 cat-parent"><i></i><a class=" " href="products/carrots.html">Fresh Vegetables</a> </li>
       <li class="cat-item cat-item-39 cat-parent"><i></i><a class=" " href="products/carrots.html">Fresh Vegetables</a> </li>
       <li class="cat-item cat-item-39 cat-parent"><i></i><a class=" " href="products/carrots.html">Fresh Vegetables</a> </li>
       <li class="cat-item cat-item-39 cat-parent"><i></i><a class=" " href="products/carrots.html">Fresh Vegetables</a> </li>
       <li class="cat-item cat-item-39 cat-parent"><i></i><a class=" " href="products/carrots.html">Fresh Vegetables</a> </li>
       
         </ul> 
         
         
		 </div>
		</div>
		</div>
<div id="shopify-section-home-sidebar-promoimage" class="shopify-section"> 
<div data-section-id="home-sidebar-promoimage" data-section-type="home-sidebar-promoimage" class="home-sidebar-promoimage">  
  <div class="widget widget_promo_img" style="background:#ffffff">
    <ul id="promo-carousel" class="owl-carousel owl-theme owl-loaded owl-drag">
    <div class="owl-stage-outer">
    <div class="owl-stage" style="transform: translate3d(-344px, 0px, 0px); transition: all 0s ease 0s; width: 860px;"><div class="owl-item cloned" style="width: 172px;"><li>
        <a href="" title="Fresh Vegetable"> 
          <img src="//cdn.shopify.com/s/files/1/0029/7100/9142/files/img-1_7002e5a9-cc69-4a06-83d3-4cf2428035a1_750x750.jpg?v=1531481646" alt="Fresh Vegetable" title="Fresh Vegetable">       
          <h5>Fresh Vegetable</h5>
        </a>
      </li></div><div class="owl-item cloned" style="width: 172px;"><li>
        <a href="" title="Fresh Vegetable"> 
          <img src="//cdn.shopify.com/s/files/1/0029/7100/9142/files/img-1_7002e5a9-cc69-4a06-83d3-4cf2428035a1_750x750.jpg?v=1531481646" alt="Fresh Vegetable" title="Fresh Vegetable">       
          <h5>Fresh Vegetable</h5>
        </a>
      </li></div><div class="owl-item active" style="width: 172px;"><li>
        <a href="" title="Fresh Vegetable"> 
          <img src="//cdn.shopify.com/s/files/1/0029/7100/9142/files/img-1_7002e5a9-cc69-4a06-83d3-4cf2428035a1_750x750.jpg?v=1531481646" alt="Fresh Vegetable" title="Fresh Vegetable">       
          <h5>Fresh Vegetable</h5>
        </a>
      </li></div><div class="owl-item cloned" style="width: 172px;"><li>
        <a href="" title="Fresh Vegetable"> 
          <img src="//cdn.shopify.com/s/files/1/0029/7100/9142/files/img-1_7002e5a9-cc69-4a06-83d3-4cf2428035a1_750x750.jpg?v=1531481646" alt="Fresh Vegetable" title="Fresh Vegetable">       
          <h5>Fresh Vegetable</h5>
        </a>
      </li></div><div class="owl-item cloned" style="width: 172px;"><li>
        <a href="" title="Fresh Vegetable"> 
          <img src="//cdn.shopify.com/s/files/1/0029/7100/9142/files/img-1_7002e5a9-cc69-4a06-83d3-4cf2428035a1_750x750.jpg?v=1531481646" alt="Fresh Vegetable" title="Fresh Vegetable">       
          <h5>Fresh Vegetable</h5>
        </a>
      </li></div></div></div><div class="owl-nav disabled"><div class="owl-prev">prev</div><div class="owl-next">next</div></div><div class="owl-dots disabled"><div class="owl-dot active"><span></span></div></div></ul>
  </div>
</div>
</div>



		
</div>
		</div>
		
		
<div class="grid__item wide--four-sixths post-large--six-tenths second">      
		  <div id="shopify-section-1523102326368" class="shopify-section index-section index-section--flush">
		  <div class="wrapper" style="height: 370px;">
    <div class="home-slideshow">
     <!--  <div class="variable-width owl-carousel owl-theme" data-slick='{ -->
      <div class="variable-width " data-slick='{
      dots: true,
      slidesToScroll: 1,
      autoplay:true,
      fade: false,
      autoplaySpeed:5000
	  }'>
        
          <div class="slick-list slideshow__slide--1523102326368-0" style=" height: 90%;">
			<img src="${pageContext.request.contextPath}/static/website/img/grocery-1_2000xa2aa.jpg?v=1533624560" data-url="/collections/all" class="slide-img medium-down--hide" alt="" />
			<img src="${pageContext.request.contextPath}/static/website/img/groceries-img1_e3e6bf10-3880-4318-a1d2-1b1dd83a07d2_767x679c.jpg?v=1535004645" data-url="/collections/all" class="slide-img wide--hide post-large--hide large--hide" alt="" />
				<div class="slider-content slider-content-1-bg  right-content "  style="  background:#47a602;position:absolute; top:auto;bottom:6%;right:2%;left:auto;text-align:right;left: auto !important;height: 90%;">
                
                <div class="slide_left" style="">
                  <h5 class="slide-text animated " style="font-weight:normal;font-size: 24px;color:#ffdc3c;">
                  Introducing
                </h5>
                <h2 class="slide-heading animated "style="font-weight:300;font-size: 34px;color:#ffffff;">
                  fresh food for   <br>
                  <b>fresh mood</b>  
                </h2>
              <div class="slide_middle">
                <h6 class="slide-offer btn animated " style="font-size: 16px;color:#22430a;background:#fff;">
                  100% organic / 20% off select products
                </h6>
                </div>
                </div>
                <div class="slider_btn">
                <a style="color:#fff;" href="collections/all.html" class="slide-button animated ">                    
                  Shop now   <i class="fa fa-long-arrow-right"></i>               
          		</a>
                </div>
               </div>
          </div>
	<%--  <div class="slick-list slideshow__slide--1533278137317">
				<img src="${pageContext.request.contextPath}/static/website/img/grocery-3_2000xe288.jpg?v=1533624651" data-url="" class="slide-img medium-down--hide" alt="" />
				<img src="${pageContext.request.contextPath}/static/website/img/groceries-img2_88130977-e2cf-4ae4-8f4c-7370f04b3efe_767xae75.jpg?v=1535004682" data-url="" class="slide-img wide--hide post-large--hide large--hide" alt="" />
				<div class="slider-content slider-content-2-bg center-content  "style="  background:#5b547d;text-align:center;">
				  <div class="slide_left" style=" width:100%;text-align:center; ">
                  <h5 class="slide-text animated " style="font-weight:normal;font-size: 24px;color:#ffdc3c;">
                  Introducing
                </h5>
                <h2 class="slide-heading animated "
                    style="font-weight:300;font-size: 34px;color:#ffffff;">
                  farm fresh   <br>
                  <b>organic vegetables<b></b></b>  
                </h2>
                <div class="slide_middle">
                <h6 class="slide-offer btn animated " style="font-size: 16px;color:#000;background:#fff;">
                  50% off select products
                </h6>
                </div>
               </div>
                 
                <div class="slider_btn">
                <a style="color:#fff;" href="#" class="slide-button animated ">                    
                  Shop Now   <i class="fa fa-long-arrow-right"></i>               
          		</a>
                </div>
                 
              </div>
           </div> --%>
<%-- <div class="slick-list slideshow__slide--1533278154861">
		<img src="${pageContext.request.contextPath}/static/website/img/groceries_2000x94f0.jpg?v=1534153380" data-url="" class="slide-img medium-down--hide" alt="" />
		<img src="${pageContext.request.contextPath}/static/website/img/groceries-img3_6b017efd-7684-47c7-9201-d5c852938e13_767x5633.jpg?v=1535004704" data-url="" class="slide-img wide--hide post-large--hide large--hide" alt="" />
		<div class="slider-content slider-content-3-bg   left-content " style="  background:#764630; left:5%;position:absolute;top:auto;bottom:7%;text-align:left; right: auto !important;">
                <div class="slide_left" style="">
                  <h5 class="slide-text animated "style="font-weight:normal; font-size: 24px;color:#ffdc3c;">
                  Introducing
                </h5>
                <h2 class="slide-heading animated "style="font-weight:300;font-size: 34px;color:#ffffff;">
                  a warm touch   <br>
                  <b>on your favorite</b>  
                </h2>
                <div class="slide_middle">
                <h6 class="slide-offer btn animated "style="font-size: 16px;color:#22430a;background:#fff;">
                  50% off select products
                </h6>
                </div>
                </div>
                 <div class="slider_btn">
                <a style="color:#fff;" href="#" class="slide-button animated ">                    
                  Shop Now   <i class="fa fa-long-arrow-right"></i>               
          		</a>
                </div>
                 
              </div>
            
            
          </div> --%>
        
      </div>
    </div>
</div> 
<script>  
  $(document).on('ready', function() {
  $('.variable-width').slick({
    dots: true,
    slidesToScroll: 1,
    autoplay:true,
    fade: false,
    autoplaySpeed:5000,
    afterChange: function(slick, currentSlide){
    console.log(currentSlide);
  }
});   
  })
</script>
<style>  
  @media screen and (min-width: 768px) and (max-width: 1200px) { .right-content { right:2% !important;} }
</style>
<style>
@media screen and (min-width: 768px) and (max-width: 1200px) { .right-content { right:2% !important;} }
</style>
<style>
 @media screen and (min-width: 768px) and (max-width: 1200px) { .right-content { right:2% !important;} }
</style>
<style>
  .home-slideshow  .slick-arrow:before{ color: #fff; }  
</style>
</div>		

<div id="shopify-section-1527764405379" class="shopify-section index-section" style="margin-top: -3%;">
<div data-section-id="1527764405379"  data-section-type="category-listing-type-1" class="category-listing-type-1">
      <div class="grid-uniform">
       <ul class="category-listing_block">         
              
        
        
        <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                     
                  <div class="category_image">                      
                  
                    <a href="products/papaya.html">
                      
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-1_033cb48c-7096-43d7-a565-1a0eb5027047_medium8b01.png?v=1531806720" alt="Fresh juice" />
                    </a>
                      
                 </div>
               <div class="category_text"> 
                     
                  <h4 style="">Fresh juice</h4>
                                    
                   </div>                                
            </div>
        </div>       
      </li>  
      <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                <div class="category_image">                      
                  <a href="products/carrots.html">
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-2_a3585dd3-d44c-4cd4-9041-6ebad849c690_medium4f9c.png?v=1531806729" alt="Carrot" />
                       
                    </a>
                      
                 </div>
                <div class="category_text"> 
                 <h4 style="">Carrot</h4>
                   </div>                                
            </div>
        </div>       
      </li>  
        <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                 <div class="category_image">                      
                  <a href="products/chicken-eggs.html">
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-4_3308acb8-8b27-4855-ae70-c1d9d6fb8f59_mediumfdd7.png?v=1531806739" alt="Fresh Meat" />
                    </a>
                 </div>
               <div class="category_text"> 
                 <h4 style="">Fresh Meat</h4>
                   </div>                                
            </div>
        </div>       
      </li>  
      <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                 <div class="category_image">                      
                  <a href="products/cup-cake.html">
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-3_58a76024-051e-4404-96ca-8c27a68fa12a_mediumf769.png?v=1531806754" alt="Ice Cream" />
                   </a>
                   </div>
               <div class="category_text"> 
                  <h4 style="">Ice Cream</h4>
                   </div>                                
            </div>
        </div>       
      </li>  
       <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                 <div class="category_image">                      
                   <a href="products/grapes.html">
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-5_60ee03a3-985d-437e-a127-eb82f5e784e6_medium4f8b.png?v=1531806769" alt="Apple" />
                    </a>
                 </div>
               <div class="category_text"> 
                 <h4 style="">Apple</h4>
                  </div>                                
            </div>
        </div>       
      </li>  
       <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                   <div class="category_image">                      
                  <a href="products/walnuts.html">
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-6_10ec4d00-602e-430c-ba44-aeaef6386762_medium55af.png?v=1531806805" alt="Cup Cream" />
                    </a>
                 </div>
               <div class="category_text"> 
                 <h4 style="">Cup Cream</h4>
                  </div>                                
            </div>
        </div>       
      </li>  
       <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                  <div class="category_image">                      
                   <a href="products/chicken-breast.html">
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-8_1186b0f0-8e00-464c-8836-cc30b74081b9_mediume21d.png?v=1531806819" alt="Breast Meat" />
                    </a>
                   </div>
               <div class="category_text"> 
                  <h4 style="">Breast Meat</h4>
                   </div>                                
            </div>
        </div>       
      </li>  
       <li class="grid__item wide--one-eighth post-large--one-eighth large--one-eighth medium--one-quarter small--one-half"  data-wow-delay="ms">
          <div class="category-listing_section">                      
             <div class="category-listing_inner" style="">    
                  <div class="category_image">                      
                    <img src="${pageContext.request.contextPath}/static/website/img/icon-7_23d2037a-fa07-4d33-ad99-9de5212925ce_medium1824.png?v=1531806831" alt="Cool Drinks" />
                   </div>
               <div class="category_text"> 
                  <h4 style="">Cool Drinks</h4>
                   </div>                                
            </div>
        </div>       
      </li>  
   </ul>
<div class="dt-sc-hr-invisible-small"></div> 
      </div>
</div>
<style type="text/css">
  .category-listing-type-1 .category-listing_inner { background:#fff; }
  .category-listing-type-1 .category-listing_inner:hover { background:#b0d235; }
  .category-listing-type-1 .category-listing_inner .category_text h4 { color:#000000; }
  .category-listing-type-1 .category-listing_inner:hover .category_text h4 { color:#fff; }
  .category-listing-type-1 .category-listing_inner:hover ul li .category-listing_section { border-color:#b0d235;}
  
  .category-listing_inner ul li a:hover { color: !important; }
  .category-listing-type-1 .category-listing_inner:hover {    box-shadow: 0 5px 10px 0 #b0d235;}
</style>

</div>
<div id="shopify-section-1523102352479" class="shopify-section index-section">
	<div data-section-id="1523102352479"  data-section-type="product-tab-type-2" class="product-tab-type-2" >     

	</div>
</div>

</div>
<div class="grid__item wide--one-sixth post-large--two-tenths third">
            <div class="homepage_sidebar right-sidebar">
              <div id="shopify-section-home-sidebar-icon-text" class="shopify-section index-section">
<div data-section-id="home-sidebar-icon-text"  data-section-type="custom-text-type-1-icon-text" class="custom-text-type-1 icon-text">  

  <div class="grid-uniform">
  		<ul class="support_block widget" style="background:#fff;float:left;width:100%;">         
            
              
      <li class="grid__item wow fadeInUp"  data-wow-delay="ms">
        <div class="custom-text_section">           
          <div class="support_section">
            <div class="support_icon">                      
              <a href="#"><img src="${pageContext.request.contextPath}/static/website/img/icons-1_06a874e6-434f-4016-be6f-8ee12bbb4ce7_smalla104.png?v=1531811887" /></a>
            </div>
            <div class="support_text"> 
             <h4 style="color:#000;">Free Shipping</h4>
              <p style="color:#848484;">Deliver to door</p>
            </div>     
          </div>
        </div>    
      </li>  
      <li class="grid__item wow fadeInUp"  data-wow-delay="ms">
        <div class="custom-text_section">           
          <div class="support_section">
              
            <div class="support_icon">                      
              <a href="#"><img src="${pageContext.request.contextPath}/static/website/img/icons-2_c928e4fc-cc20-4445-9879-459cb716c93c_small6583.png?v=1531811899" /></a>
            </div>
             <div class="support_text"> 
              <h4 style="color:#000;">24x7 Support</h4>
               <p style="color:#848484;">in safe hands</p>
           </div>     
          </div>
        </div>    
      </li>  
      <li class="grid__item wow fadeInUp"  data-wow-delay="ms">
        <div class="custom-text_section">           
          <div class="support_section">
              
            <div class="support_icon">                      
              <a href="#"><img src="${pageContext.request.contextPath}/static/website/img/icons-3_3cbea35f-7af0-495b-bb3e-cba58a5a2a55_small5a4b.png?v=1531811909" /></a>
            </div>
            <div class="support_text"> 
              <h4 style="color:#000;">Big Saving</h4>
              <p style="color:#848484;">at lowest price</p>
            </div>     
          </div>
        </div>    
      </li>  
              
      <li class="grid__item wow fadeInUp"  data-wow-delay="ms">
        <div class="custom-text_section">           
          <div class="support_section">
              
            <div class="support_icon">                      
              <a href="#"><img src="${pageContext.request.contextPath}/static/website/img/icons-4_cee3d502-64fd-4d00-91df-9d1aa779f90f_small0764.png?v=1531811918" /></a>
            </div>
            <div class="support_text"> 
             <h4 style="color:#000;">Money Back</h4>
             <p style="color:#848484;">Easy to return</p>
            </div>     
          </div>
        </div>    
      </li>  
              
      <li class="grid__item wow fadeInUp"  data-wow-delay="ms">
        <div class="custom-text_section">           
          <div class="support_section">
              
            <div class="support_icon">                      
              <a href="#"><img src="${pageContext.request.contextPath}/static/website/img/icons-5_6ba1f7c3-4b62-4a17-8e48-5b7ea028744f_smallf22f.png?v=1531811926" /></a>
            </div>
            <div class="support_text"> 
              <h4 style="color:#000;">Online Store</h4>
             <p style="color:#848484;">a huge branding</p>
             </div>     
          </div>
        </div>    
      </li>  
              
      <li class="grid__item wow fadeInUp"  data-wow-delay="ms">
        <div class="custom-text_section">           
          <div class="support_section">
              
            <div class="support_icon">                      
              <a href="#"><img src="${pageContext.request.contextPath}/static/website/img/icons-6_5c9b2103-466c-44b2-b50d-f64194cbe3ca_smalladd1.png?v=1531811934" /></a>
            </div>
            <div class="support_text"> 
              <h4 style="color:#000;">Award Winner</h4>
               <p style="color:#848484;">for best services</p>
              
            </div>     
          </div>
        </div>    
      </li>  
   </ul>
  </div>
  </div>
  </div>
  </div>
  </div>
	</div>
  	</div>
    </main>
  </div>
   <div id="shopify-section-footer-model-9" class="shopify-section"><div data-section-id="footer-model-9"  data-section-type="Footer-model-9" class="footer-model-9">
  <footer class="site-footer" style="background:#fcfcfc;">
      

      <div class="grid-uniform">         
        <div class="container">
           <div class="grid__item wide--one-quarter post-large--one-quarter large--grid__item medium--grid__item">
              <div class="footer-logo">
                                     
              <a href="javascript:(0);">
                <img class="normal-footer-logo" src="${pageContext.request.contextPath}/static/website/img/gophers-footer-logo6f06.png?v=1534147217" alt=" Gopher&#39;s Grocery" />
              </a>
                        
            </div>
                    
          <p style="color:#888888;">Pellentesque posuere orci lobortis scelerisque blandit. Donec id tellus lacinia anas.</p> 
          
             
          </div>
          <div class="grid__item wide--three-quarters post-large--three-quarters large--grid__item medium--grid__item">
          <div class="grid__item wide--one-quarter post-large--one-quarter large--one-half medium--one-half">   
            
            <h4 style="color:#000000;">Help</h4>
            
            <ul class="site-footer__links">
              
              <li><a style="color:#848484;"  href="javascript:(0);">Search</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Help</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Information</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Privacy Policy</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Shipping Details</a></li>
              
            </ul>          
          </div>
           
          
          <div class="grid__item wide--one-quarter post-large--one-quarter large--one-half medium--one-half">          
            
            <h4 style="color:#000000;"> Support</h4>
            
            <ul class="site-footer__links">
              
              <li><a style="color:#848484;"  href="javascript:(0);">Contact Us</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">About Us</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Careers</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Refunds & Returns</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Deliveries</a></li>
              
            </ul>         
          </div>
          

          
          <div class="grid__item wide--one-quarter post-large--one-quarter large--one-half medium--one-half">          
            
            <h4 style="color:#000000;">Information</h4>
            
            <ul class="site-footer__links">
              
              <li><a style="color:#848484;"  href="javascript:(0);">Search Terms</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Advanced Search</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Help & FAQ's</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Store Location</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Orders & Returns</a></li>
              
            </ul>         
          </div>
          

          
          
          <div class="grid__item wide--one-quarter post-large--one-quarter large--one-half medium--one-half">
                    
            <h4 style="color:#000000;">Contact us</h4> 
                    
                    
            <div class="address">
              
              <p style="color:#848484;">   Assem, <br> India</p>
                        
              
              <p style="color:#848484;"> <i class="fa fa-phone"></i>+91 6001 98 7297</p>
              
            </div>
            
            
           <i class="icon-envelope icons"></i> <a class="contact-mail" style="color:#848484;" href="mailto:support@somemail.com">support@onlinemarts.com</a>
                             
          </div>
                
          </div>
          <div class="grid__item">
          
                               
            <div class="site-footer__links">
            <ul>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Home</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Collection</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Shop</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Kitchen Appliance</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Groceries</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Vegetables</a></li>
              
              <li><a style="color:#848484;"  href="javascript:(0);">Pages</a></li>
              
            </ul>         
            </div>
       <div class="payment_section">                 
           <h4 style="color:#000000;"></h4>
          <div class="footer-icons">        
            <ul class="inline-list payment-icons">
              <li><a href="javascript:(0);"><img src="${pageContext.request.contextPath}/static/website/img/card-icons_0020_3_55xd8fe.png?v=1528091800" alt="payment_icon_1" /></a></li>
              <li><a href="javascript:(0);"><img src="${pageContext.request.contextPath}/static/website/img/card-icons_0009_14_55x1959.png?v=1528091815" alt="payment_icon_2" /></a></li>
              <li><a href="javascript:(0);"><img src="${pageContext.request.contextPath}/static/website/img/card-icons_0011_12_55x69a2.png?v=1528091932" alt="payment_icon_3" /></a></li>
              <li><a href="javascript:(0);"><img src="${pageContext.request.contextPath}/static/website/img/card-icons_0018_5_55x981d.png?v=1528091947" alt="payment_icon_4" /></a></li>
              <li><a href="javascript:(0);"><img src="${pageContext.request.contextPath}/static/website/img/card-icons_0023_1_55xbbee.png?v=1528091958" alt="payment_icon_5" /></a></li>
              <li><a href="javascript:(0);"><img src="${pageContext.request.contextPath}/static/website/img/card-icons_0001_22_55xb051.png?v=1528092069" alt="payment_icon_6" /></a></li>            
              <li><a href="javascript:(0);"><img src="${pageContext.request.contextPath}/static/website/img/card-icons_0010_13_55x9f7a.png?v=1528092146" alt="payment_icon_7" /></a></li>            
            </ul>                    
          </div>           
        </div>
               
          </div>
        </div>
      </div>


    
  </footer>

 

  <div class="grid__item">
    <div class="copyright" style="background:#000">
      <div class="container"> 
       
        <div class="footer-bottom">          
           
        <p class="copyright_left" style="color:#ffffff">Copyright © 2018, Online Marts  &copy; 2020,  OnlineMart&#39;s Grocery
          
          <a target="_blank" rel="nofollow" href="javascript:(0);">Powered by AssiduousTechnologies</a>
          
        </p>
                 
      </div>           
      </div>
    </div>
  </div>
</div>

 <style>
    .footer-model-9 .footer_newsletter button:hover { background: !important;color: !important; }
    .footer-model-9 .site-footer__links li a:hover,.footer-model-9 .contact-mail:hover { color:#b0d235 !important; }
    .footer-model-9 .footer-bottom .footer-bottom__menu ul li a:hover { color: !important; }
    .footer-model-9 .copyright a { color:#b0d235; }
    .footer-model-9 .copyright a:hover { color:#fff; }
    
    .footer-model-9 .footer_newsletter input::-webkit-input-placeholder {  color:;}
    .footer-model-9 .footer_newsletter input:-moz-placeholder { color:;}
    .footer-model-9 .footer_newsletter input::-moz-placeholder {  color:;}
    .footer-model-9 .footer_newsletter input:-ms-input-placeholder {  color:;}
    .footer-model-9 .footer_newsletter input { color:; }
   .footer-model-9 h5 {color:#000000; }
  </style>


</div>
         
<script type="text/javascript" src="<c:url value='/static/website/files/assets/timber365c.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/assets/jquery.inviewc3da.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/assets/core-files7163.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/assets/theme10bd.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/assets/shop7024.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/assets/jquery.donutchart0e92.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/themes_support/api.jquery-e94e010e92e659b566dbc436fdfe5242764380e00398907a14955ba301a4749f.js'/>"></script>
<script type="text/javascript" src="<c:url value='/static/website/files/themes_support/option_selection-fe6b72c2bbdd3369ac0bfefe8648e3c889efca213baefd4cfb0dd9363563831f.js'/>"></script>
 <script> 
  $(document).ready(function() {
   var body = $('body');
    var doc = $(document);
    
    var showLeftPush = $('#showLeftPush');
    var nav = $('#cbp-spmenu-s1');
    
    showLeftPush.on('click', function(e) {
      e.stopPropagation();
    
      body.toggleClass('cbp-spmenu-push-toright');
      nav.toggleClass('cbp-spmenu-open');
      showLeftPush.toggleClass('active');
    });
    
    $('.gf-menu-device-wrapper .close-menu').on('click', function() {
    	showLeftPush.trigger('click');
    });
    
    doc.on('click', function(e) {
      if (!$(e.target).closest('#cbp-spmenu-s1').length && showLeftPush.hasClass('active')) {
        showLeftPush.trigger('click');
      }        
    });
  });
</script>
  
  </div>
</body>