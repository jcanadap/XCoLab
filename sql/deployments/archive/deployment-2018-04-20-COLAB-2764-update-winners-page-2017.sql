/* insert new contentarticle version into table, created by cwoebker */

INSERT INTO `xcolab_ContentArticleVersion` (`contentArticleId`, `folderId`, `authorId`, `createDate`, `title`, `content`, `lang`)
VALUES (1214, 38, 2675595, NOW(), 'Climate CoLab Contest Winners',
'<!-- TODO: COLAB-2764 Add to sql query to change articleId=1214 -->

<script src="https://code.jquery.com/jquery-3.1.1.min.js">
</script>
<!-- ****************** STYLING ****************** -->
<style type="text/css">
    .wrapper {
        width: 984px;
        position: relative;
        margin: auto;
        visibility: hidden;
        /*This is in order to prevent OTHER YEARS flashing before JS script is loaded*/
    }

    h1 {
        display: none;
        /*This is in order to prevent the PAGE TITLE flashing before JS script is loaded*/
    }

    ul.list li {
        width: 133px;
        height: 50px;
        float: left;
        background-color: #30a3fb;
        text-align: center;
        line-height: 48px;
        margin: 1px;
        padding-top: 1px;
        border-radius: 3px;
        color: white;
        list-style-type: none;
        font-weight: 900 !Important;
    }

    ul.list li:hover {
        cursor: pointer;
        background-color: #0088f1;
    }

    ul.list {
        padding-left: 0;
        overflow: auto;
        margin-bottom: 5px;
    }

    .upper {
        /*text-transform: uppercase; */
        vertical-align: middle !Important;
    }

    .winner-picture {
        width: 100%;
    }

    .winner-icon {
        width: 220px;
        position: absolute;
        top: 32%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    .relative {
        position: relative;
        margin-top: 10px;
    }

    .image-title {
        position: absolute;
        top: 53%;
        left: 50%;
        transform: translate(-50%, -50%);
        color: white;
        font-size: 50px;
        margin-top: 30px;
    }

    .image-title-sub {
        position: absolute;
        top: 60%;
        left: 50%;
        transform: translate(-50%, -50%);
        color: white;
        font-size: 34px;
        margin-top: 30px;
        font-family: "Bree serif", Verdana, sans-serif;
    }

    .darken {
        -webkit-filter: brightness(50%);
        filter: brightness(50%);
    ;
    }

    .indigogo-button {
        border-style: solid;
        border-width: 2px;
        border-radius: 10px;
        padding: 5px;
        border-color: #eb1478;
        position: absolute;
        top: 71%;
        left: 50%;
        transform: translate(-50%, -50%);
        text-decoration: none;
        margin-top: 25px;
        background-color: #eb1478;
        text-transform: uppercase;
    }

    .indigogo-button:hover a {
        color: #f7a5cb !Important;
    }

    .indigogo-button-small {
        border-style: solid;
        border-width: 2px;
        border-radius: 10px;
        padding: 3px;
        border-color: #eb1478;
        display: inline-block;
        margin-bottom: 10px;
        background-color: #eb1478;
    }

    .indigogo-button-small:hover a {
        color: #f7a5cb !Important;
    }

    .stat-bubble-number {
        font-size: 40px !Important;
        margin: 7px;
        color: white;
    }

    .stat-bubble-title {
        margin-top: -2px;
        color: #b6eaff;
        text-transform: uppercase;
    }

    .stat-bubble-outer {
        width: 190px;
        height: 90px;
        display: inline-block;
        background-color: #30a3fb;
        margin-right: 15px;
        border-radius: 10px;
        margin-top: 20px;
    }

    .expander:hover {
        cursor: pointer;

    }

    .contest-kind-header {
        margin-bottom: 15px;
        margin-top: 30px;
    }

    .contest-kind-header td {
        vertical-align: middle;
    }

    .icons {
        height: 40px;
        vertical-align: middle;
    }

    .icon-title {
        display: inline;
        vertical-align: middle;
        color: #6bb33d;
        font-family: "proxima-nova", "proxima-nova-1", Arial, Helvetica, sans-serif;
        line-height: 41px;
        font-weight: 600;
        font-size: 28px;
    }

    .contest-title {
        color: #30a3fb;
        font-size: 20px;
        text-transform: uppercase;
        font-weight: 700;
    }

    .contest-wrapper {
        margin-bottom: 20px;
    }

    .accordion-element {
        width: 100%;
        background-color: #e9f0f4;
        margin-bottom: 3px;
        border-radius: 7px;
        text-align: initial;
        padding: 5px 0;
    }

    .accordion-element {
        cursor: pointer;
    }

    .accordion-icon {
        width: 32px;
        vertical-align: middle;
        margin: 5px;
        margin-left: 18px;
        margin-right: 20px;
    }

    .accordion-inner {
        padding: 5px 10px 5px 40px;
        background-color: #fbfbfb;
        border-style: solid;
        border-width: 1px;
        border-color: #e9f0f4;
        color: grey;
    }

    .accordion-inner-no {
        padding: 5px 10px 5px 40px;
        background-color: #fbfbfb;
        border-style: solid;
        border-width: 1px;
        border-color: #e9f0f4;
        color: grey;
    }

    .accordion-inner:hover {
        cursor: initial;
    }

    .accordion-inner-header {
        margin-top: 10px;
        margin-bottom: 15px;
        font-weight: bold;
    }

    .accordion-inner-header-special {
        margin-top: 10px;
        margin-bottom: 5px;
        font-weight: bold;
    }

    .accordion-element-inner {
        color: grey;
    }

    .accordion-icon-inner {
        height: 25px;
        vertical-align: middle;
        margin-right: 10px;
    }

    .accordion-icon-inner-special {
        height: 34px !Important;
    }

    .blue-line {
        border: 1px #30a3fb;
        margin: 0;
    }

    .contest-table-icon {
        width: 80px;
        text-align: center;
    }

    .contest-table-icon img {
        margin-left: -9px;
    }

    .contest-title-under {
        font-size: 19px;
        color: #6bb33d
    }

    .contest-title-under-special {
        font-size: 16px;
    }

    .contest-proposal {
        font-size: 18px;
        margin-bottom: 10px !Important;
    }

    .contest-proposal a {
        text-decoration: underline;
    }

    .contest-proposal-special {
        font-size: 16px;
        margin-bottom: 7px;
    }

    .contest-proposal-special a {
        text-decoration: underline;
    }

    .contest-proposal-description {
        color: #6f6f6f;
    }

    .sponsor-logo {
        height: 80px;
        opacity: 0.7;
        border-style: solid;
        padding: 11px;
        border-width: 1px;
        border-radius: 10px
    }

    .single-winner-image {
        width: 165px;
        float: left;
        margin-right: 17px;
    }

    .single-winner {
        /* overflow: overlay; */
        background-color: #e9f0f4;
        /* border-style: solid;
    border-width: 1px;
    border-color: #30a3fb; */
        text-align: left;
        padding: 10px;
        color: grey;
    }

    .single-winner a {
        text-decoration: underline;
    }

    .single-winner-title {
        font-size: 24px;
        color: #6f6f6f;
        font-weight: 600;
        margin-bottom: 10px;
    }

    .single-winner-proposal {
        font-size: 17px;
        margin-bottom: 10px;
    }

    .single-winner-description {
        color: #888888;
    }

    #scroller {
        position: fixed;
        right: 50%;
        bottom: 10px;
        margin-right: -600px;
        display: none;
        cursor: pointer;
        height: 50px;
    }

    @media (max-device-width: 425px) {

        #scroller {
            position: fixed;
            right: 50%;
            bottom: 30px;
            margin-right: -400px;
            display: none;
            cursor: pointer;
            height: 120px;
        }
    }
</style>
<!-- ****************** START CONTENT ****************** -->
<div class="wrapper">
    <!-- NAVIGATION-->
    <ul class="list">
        <!-- <li id="20120" class="year"> 2020 </li> -->
        <!-- <li id="2019" class="year"> 2019 </li> -->
        <!-- <li id="2018" class="year"> 2018 </li> -->
        <li class="year" id="2017">2017</li>
        <li class="year" id="2016">2016</li>
        <li class="year" id="2015">2015</li>
        <li class="year" id="2014">2014</li>
        <li class="year" id="2013">2013 / 2012</li>
        <li class="year" id="2011">2011</li>
        <li class="year" id="2010">2010</li>
        <li class="year" id="2009">2009</li>
    </ul>
    <!-- ****************** 2020 ****************** -->

    <div class="2020 content">
        <div class="relative">
            <img class="winner-picture darken" src="--INSERT PICTURE LINK HERE--" />
            <img class="winner-icon" src="https://i.imgur.com/BdMVyXr.png" />
            <h1 class="upper image-title">Contest Winners</h1>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indigogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
    </div>
    <!-- ****************** 2019 ****************** -->

    <div class="2019 content">
        <div class="relative">
            <img class="winner-picture darken" src="--INSERT PICTURE LINK HERE--" />
            <img class="winner-icon" src="https://i.imgur.com/YHpReIA.png" />
            <h1 class="upper image-title">Contest Winners</h1>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
    </div>
    <!-- ****************** 2018 ****************** -->

    <div class="2018 content">
        <div class="relative">
            <img class="winner-picture darken" src="--INSERT PICTURE LINK HERE--" />
            <img class="winner-icon" src="https://i.imgur.com/jG90QBz.png" />
            <h1 class="upper image-title">Contest Winners</h1>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indigogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">XX</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
    </div>
    <!-- ****************** 2017 ****************** -->

    <div class="2017 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://i.imgur.com/vVFVYcy.png" />
            <img class="winner-icon" src="https://i.imgur.com/pMCwIxD.png" />
            <h1 class="upper image-title">Contest Winners</h1>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">8</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">372</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">19</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <a class="upper expander" onclick="expandAll(this)">expand all</a>
        <br />
        <!-- OTHER CONTEST -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td>
                    <h1 class="upper icon-title">Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Adaptation</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/adaptation/c/proposal/1333933">Incentivized disaster preparedness & gamification</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/adaptation/c/proposal/1333933/tab/TEAM">Saadithya + Sarkar</a>
                </p>

                <p class="contest-proposal-description">Platform to drive disaster risk preparedness with chatbots, gamification, incentives, insurance innovation;
                    & bridge multiple stakeholders.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Practice </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/adaptation/c/proposal/1334071">Naturally heated homes for colder and poorer regions of the world</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/adaptation/c/proposal/1334071/tab/TEAM">Javed Sultan</a>
                </p>

                <p class="contest-proposal-description">Searching for Building Technology that are less fossil fuel dependent, affordable, encourage capacity building,
                    and more climate responsive.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/adaptation/c/proposal/1334101">User-Maintained, Highly Efficient Solar Powered Water Purification Systems</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/adaptation/c/proposal/1334101/tab/TEAM">PV Pure</a>
                </p>

                <p class="contest-proposal-description">Our solar-power purification systems are cost-effective, easy to maintain, and sustainably use varied water
                    sources to combat disaster risk.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Buildings</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Practice </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/buildings/c/proposal/1334055">Naturally heated homes for colder and poorer regions of the world</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/buildings/c/proposal/1334055/tab/TEAM">Javed Sultan</a>
                </p>

                <p class="contest-proposal-description">Teaching people to build low carbon footprint, energy efficient, and naturally heated homes in poorer and colder regions of the world.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/buildings/c/proposal/1334187">willpower-energy: Make your own fuel from CO2 at home</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/buildings/c/proposal/1334187/tab/TEAM">
                        Alexia Ferreira Teren and 1 other</a>
                </p>

                <p class="contest-proposal-description">willpower-energy makes it possible to transform atmospheric CO2 into fuel and to store energy – in your own home for your own home.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/buildings/c/proposal/1334187">willpower-energy: Make your own fuel from CO2 at home</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/buildings/c/proposal/1334187/tab/TEAM">
                        Alexia Ferreira Teren and 1 other</a>
                </p>

                <p class="contest-proposal-description">willpower-energy makes it possible to transform atmospheric CO2 into fuel and to store energy – in your own home for your own home.</p>
            </div>
        </div>
        <!-- Contest Accordion 5 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Carbon Pricing</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/carbon-pricing/c/proposal/1334152">Put A Price On It</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/carbon-pricing/c/proposal/1334152/tab/TEAM">Our Climate</a>
                </p>

                <p class="contest-proposal-description">Empower students and millennials across the U.S. to hold polluters accountable with a price on carbon pollution.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Practice </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/carbon-pricing/c/proposal/1334008">Proxy pricing carbon in state govt procurement, contracting, and acquistion</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/carbon-pricing/c/proposal/1334008/tab/TEAM">Adele Morris</a>
                </p>

                <p class="contest-proposal-description">Proxy pricing adds a hypothetical carbon surcharge to market energy prices when choosing among emissions-intensive goods and services.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/carbon-pricing/c/proposal/1333986">Revenue Neutral Carbon Fee and Dividend: Bending the Emissions Curve</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/carbon-pricing/c/proposal/1333986/tab/TEAM">CitizensClimateLobby</a>
                </p>

                <p class="contest-proposal-description">A revenue neutral, rising fee on GHG emissions will steer the economy to a low-carbon future and re-establish US climate leadership.</p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Energy Supply</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/energy-supply/c/proposal/1334134">HELIAC Solar Cooker – Inexpensive, But Efficient</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/energy-supply/c/proposal/1334134/tab/TEAM">HELIAC</a>
                </p>

                <p class="contest-proposal-description">The Heliac Solar Cooker is inexpensive but efficient. A lens focusing sunlight generates heat. Improvements, distribution, & sales welcome.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/energy-supply/c/proposal/1334172">Clean cooking solutions and development of a climate change mitigation programme</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/energy-supply/c/proposal/1334172/tab/TEAM">Climate Advocacy</a>
                </p>

                <p class="contest-proposal-description">Replacement of open fire stoves with improved cookstoves can reduce indoor air pollution & can cut the amount of GHG emissions significantly.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/energy-supply/c/proposal/1334179">Community micro hydropower generation in the Hispaniola island</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/energy-supply/c/proposal/1334179/tab/TEAM">REDSER</a>
                </p>

                <p class="contest-proposal-description">Community managed micro hydropower systems are a key instrument for climate change mitigation and sustainable development at local scale.</p>
            </div>
        </div>
        <!-- Contest Accordion 6 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Land Use: Agriculture, Forestry, Waste Management</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/land-use-agriculture-forestry-waste-management/c/proposal/1333931">Developing an Alternative to Shifting Cultivation in North-East India.</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/land-use-agriculture-forestry-waste-management/c/proposal/1333931/tab/TEAM">David Gandhi and 4 others</a>
                </p>

                <p class="contest-proposal-description">The SALT approach will be adapted to offer hill tribes a sustainable and climate smart alternative to shifting cultivation.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/land-use-agriculture-forestry-waste-management/c/proposal/1333931">Developing an Alternative to Shifting Cultivation in North-East India.</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/land-use-agriculture-forestry-waste-management/c/proposal/1333931/tab/TEAM">David Gandhi and 4 others</a>
                </p>

                <p class="contest-proposal-description">The SALT approach will be adapted to offer hill tribes a sustainable and climate smart alternative to shifting cultivation.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/land-use-agriculture-forestry-waste-management/c/proposal/1334163">Assam Fuelwood Decision Support System (AFDSS)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/land-use-agriculture-forestry-waste-management/c/proposal/1334163/tab/TEAM">Swapan Mehra and 5 others</a>
                </p>

                <p class="contest-proposal-description">Systems dynamics modelling approach to address unsustainable extraction of fuelwood from forests and promote adoption of clean technologies</p>
            </div>
        </div>
        <!-- Contest Accordion 7 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Shifting Attitudes & Behaviors</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/shifting-attitudes-and-behavior/c/proposal/1333979">Climate Stories: a mobile community planning hub for climate adaptation</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/shifting-attitudes-and-behavior/c/proposal/1333979/tab/TEAM">Urban Fabrick</a>
                </p>

                <p class="contest-proposal-description">Climate Stories is an interactive mobile community hub for climate change engagement, planning & action.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/shifting-attitudes-and-behavior/c/proposal/1334191">Youth Climate Leaders (YCL)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/shifting-attitudes-and-behavior/c/proposal/1334191/tab/TEAM">Cassia Moraes and 4 others</a>
                </p>

                <p class="contest-proposal-description">Young people traveling the world and working together to learn more about climate change and start their careers as climate leaders.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/shifting-attitudes-and-behavior/c/proposal/1334191">Youth Climate Leaders (YCL)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/shifting-attitudes-and-behavior/c/proposal/1334191/tab/TEAM">Cassia Moraes and 4 others</a>
                </p>

                <p class="contest-proposal-description">Young people traveling the world and working together to learn more about climate change and start their careers as climate leaders.</p>
            </div>
        </div>
        <!-- Contest Accordion 8 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Transportation</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/transportation/c/proposal/1333946">Solar powered boats; fostering marine eco-conservation</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/transportation/c/proposal/1333946/tab/TEAM">Birupakshya Dixit and 1 other</a>
                </p>

                <p class="contest-proposal-description">Use of Solar boats in tourist places can reduce the air, water and noise pollution.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner Project (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/transportation/c/proposal/1333987">Detox the Fleet</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/transportation/c/proposal/1333987/tab/TEAM">Bill Ferree and 2 others</a>
                </p>

                <p class="contest-proposal-description">Battery electric drive retrofit protocol for small commercial vehicles. Used cars, vans, delivery trucks–carbon emission free.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2017/transportation/c/proposal/1333946">Solar powered boats; fostering marine eco-conservation</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2017/transportation/c/proposal/1333946/tab/TEAM">Birupakshya Dixit and 1 other</a>
                </p>

                <p class="contest-proposal-description">Use of Solar boats in tourist places can reduce the air, water and noise pollution.</p>
            </div>
        </div>
        <!-- Partner Contest -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/ZdFe2g0.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Partner Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Anticipating Climate Hazards</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://a2rinitiative.org/">
                        <img class="sponsor-logo" src="https://news.climatecolab.org/wp-content/uploads/2017/07/147499226422551.png"
                        />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://climatecolab.org/contests/2017/A2R-Anticipating-Climate-Hazards/c/proposal/1333836">Improving Disaster Preparedness of Deaf People, Philippines</a>
                    <span> by </span>
                    <a href="https://climatecolab.org/contests/2017/A2R-Anticipating-Climate-Hazards/c/proposal/1333836/tab/TEAM">Rommel Lo</a>
                </p>

                <p class="contest-proposal-description">Helping the Deaf community prepare for disasters begins with signing the signs of disaster.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://climatecolab.org/contests/2017/A2R-Anticipating-Climate-Hazards/c/proposal/1333834">The VNMS and Lifetowers: Solutions for last mile early warning dissemination</a>
                    <span> by </span>
                    <a href="https://climatecolab.org/contests/2017/A2R-Anticipating-Climate-Hazards/c/proposal/1333834/tab/TEAM">Animesh Prakash</a>
                </p>

                <p class="contest-proposal-description">Low cost solutions for effective last mile early warning dissemination.</p>
            </div>
        </div>
    </div>
    <!-- ****************** 2016 ****************** -->

    <div class="2016 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://i.imgur.com/nz6INVe.jpg" />
            <!-- <img class="image-title" src="http://image.flaticon.com/teams/1-freepik.jpg"> -->
            <img class="winner-icon" src="https://i.imgur.com/4jfE658.png" />
            <h1 class="upper image-title">Contest Winners</h1>

            <p class="image-title-sub">&amp; Awardees</p>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">17</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">579</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">27</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <!-- GRAND PRIZE WINNER -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/YwSKO89.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Grand Prize Winner</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <div style="float: left; height: 163px;">
                <img class="single-winner-image" src="https://i.imgur.com/u7k6Ub3.jpg" />
            </div>

            <p class="single-winner-title">Climate Smart</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331567">Interactive Business Energy and Emissions Dashboard for Cities</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/2475075">ana0105</a>
            </p>

            <p class="single-winner-description">&ldquo;We&rsquo;re deeply humbled and inspired by this recognition,&rdquo; said Elizabeth Sheehan, Climate Smart
                President and CEO. &ldquo;Cities are the front lines in the climate challenge, yet often have limited resources.
                Our software helps them get the most bang for their buck, so they can be more effective in their work.&rdquo;&ldquo;We&rsquo;re
                deeply humbled and inspired by this recognition,&rdquo; said Elizabeth Sheehan, Climate Smart President and
                CEO. &ldquo;Cities are the front lines in the climate challenge, yet often have limited resources. Our software
                helps them get the most bang for their buck, so they can be more effective in their work.&rdquo;</p>
        </div>
        <!-- HONORABLE MENTIONS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/f9566RT.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Honorable Mentions</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/LpmSVAZ.jpg" />
            <p class="single-winner-title">Benjamin Huber and Juna Shrestha of ClimateRe</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1329810">Reducing methane emissions from rice farming</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/2410050">jshrestha</a>
            </p>

            <p class="single-winner-description">They proposed a mechanism to reduce methane emissions while enhancing rice farmers&rsquo; resilience to climate
                change.</p>
        </div>
        &nbsp;

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/8coUdVr.jpg" />
            <p class="single-winner-title">James Gula of Franchised Microgrids</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1331563">Franchised Microgrids for the Developing World Based on Open Source Components</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/2387272" target="_blank">jlgula</a>
            </p>

            <p class="single-winner-description">They proposed to deploy microgrids to the developing world using a franchise business model based on open source
                hardware to reduce cost.</p>
        </div>
        &nbsp;

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/tiVQidA.jpg" />
            <p class="single-winner-title">Nishaant Sangaavi and Alex Corneglio of My Energy XPert</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331647">My Energy Xpert: a home and small business energy management solution</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/2469674">alex7728</a>
            </p>

            <p class="single-winner-description">They built &quot;My Energy Xpert&quot; which is a SMART energy audit and monitoring app empowering people to
                save time, money and lower their energy footprint.</p>
        </div>
        <br />
        <br />
        <a class="upper expander" onclick="expandAll(this)">expand all</a>
        <br />
        <!-- OTHER CONTEST -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td>
                    <h1 class="upper icon-title">Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Adaptation</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331645">Hudson River Sustainable Shorelines Project</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331645/tab/TEAM">Sustainable Shores</a>
                </p>

                <p class="contest-proposal-description">Sustainable Shorelines generates info about best shoreline management options preserving ecology through
                    adapting to climate change impacts.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331643">Vulnerability Assessment and Adaptation Strategies for Property and Community</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331645/tab/TEAM">Climate.IQ</a>
                </p>

                <p class="contest-proposal-description">Climate.IQ is a web tool that uses spatial and statistical analysis to conduct climate risk assessmennt for
                    properties and communities.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331109">Build reefs to sustain oceans&rsquo; adaptation to a warmer world</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331109/tab/TEAM">SDO CLIMA</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331504">Unleashing the climate-smart potential of Africa&rsquo;s forgotten rice</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/adaptation/c/proposal/1331504/tab/TEAM">sririce</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Buildings</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice &amp; Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/buildings/c/proposal/1331569">Cooperative Building</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/buildings/c/proposal/1331569/tab/TEAM">Kaenga</a>
                </p>

                <p class="contest-proposal-description">Let&#39;s build more sustainable buildings by empowering people to design their homes and shape their communities.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (At Large)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/buildings/c/proposal/1329803">RentRocket.org - Bringing transparent energy data to rental housing markets</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/buildings/c/proposal/1329803/tab/TEAM">
                        RentRocket.org</a>
                </p>

                <p class="contest-proposal-description">If we want to reverse climate change, we have to reach people who don&#39;t think about it. Let&#39;s make
                    climate-friendly housing decisions easy.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact &amp; Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/buildings/c/proposal/1331539">Naturally heated homes for colder and poorer regions of the world</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/buildings/c/proposal/1331539/tab/TEAM">Javed Sultan</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Energy Supply</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1331563">Franchised Microgrids for the Developing World Based on Open Source Components</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1331563/tab/TEAM">jlgula</a>
                </p>

                <p class="contest-proposal-description">Deploy microgrids to the developing world using a franchise business model based on open source hardware
                    to reduce cost.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/fuel-carbon-contributions/c/proposal/1329009">The Collective Power Platform</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1331594/tab/TEAM">
                        roelofsmichiel</a>
                    <span> and </span>
                    <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/2473684"> nikodem.bienia</a>
                </p>

                <p class="contest-proposal-description">The Collective Power Platform is a local peer to peer energy trading market for and by prosumers.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1331502">Faciliating Adaptation to Climate Change through Solar Irrigation Technology</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1331502/tab/TEAM">Tareo</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1330701">Insulator Slow Cooker Bags</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-supply/c/proposal/1330701/tab/TEAM">marole</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 4 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Energy-Water Nexus</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331631">Infrastructure for a Livable Future</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331631/tab/TEAM">CRWA</a>
                </p>

                <p class="contest-proposal-description">Community Water and Energy Centers produce reliable, renewable and resilient energy and clean water while
                    restoring the natural environment.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331631">Infrastructure for a Livable Future</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331631/tab/TEAM">CRWA</a>
                </p>

                <p class="contest-proposal-description">Community Water and Energy Centers produce reliable, renewable and resilient energy and clean water while
                    restoring the natural environment.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331631">Infrastructure for a Livable Future</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331631/tab/TEAM">CRWA</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331506">Distilled Water From Combusted Fossil Fuel</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/energy-water-nexus/c/proposal/1331506/tab/TEAM">Sidel Systems USA</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 5 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Industry</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1329804">25&ordm;C (77&ordm;F)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1329804/tab/TEAM">Kiri</a>
                </p>

                <p class="contest-proposal-description">Regulate industry globally so all new air conditioners have a minimum of 25&ordm;C (77&ordm;F). Reset existing
                    equipment to comply this new standard.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1329804">25&ordm;C (77&ordm;F)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1329804/tab/TEAM">Kiri</a>
                </p>

                <p class="contest-proposal-description">Regulate industry globally so all new air conditioners have a minimum of 25&ordm;C (77&ordm;F). Reset existing
                    equipment to comply this new standard.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1329804">25&ordm;C (77&ordm;F)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1329804/tab/TEAM">Kiri</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1326902">Solar Steam</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/industry/c/proposal/1326902/tab/TEAM">sunflower</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 6 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Land Use: Agriculture, Forestry, Livestock</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1329810">Reducing methane emissions from rice farming</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1329810/tab/TEAM">ClimateRe</a>
                </p>

                <p class="contest-proposal-description">Reducing Methane Emissions While Enhancing Rice Farmers&rsquo; Resilience to Climate Change</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1331576">Vertical and Micro-gardening(VMG) climate smart farming in Uganda</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1331576/tab/TEAM">PaulCastor</a>
                </p>

                <p class="contest-proposal-description">VMG is a CSA approach that uses the Vertical farming technology to convert 9 square feet into 36 square feet
                    of farming space.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1330825">Preservation + restoration of blue carbon ecosystems require immediate attention</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1330825/tab/TEAM">MoorooducRH</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty (tie)</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1322803">Honey Bees = Polination = crops = food Pollination = Photosynthesis = lower C02</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1322803/tab/TEAM">Kelvin Valley Honey</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty (tie)</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1331536">Green Cambridge Street Tree Biochar Pilot Study</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/land-use-agriculture-forestry-livestock/c/proposal/1331536/tab/TEAM">Green Cambridge</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 7 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Shifting Behavior for a Changing Climate</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1330118">DearTomorrow, a promise to the future about climate change</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1330118/tab/TEAM">deartomorrow.org</a>
                </p>

                <p class="contest-proposal-description">To shift behavior and broaden the climate culture, we invite people to send open letters about climate change
                    to loved ones in the future.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1330607">What is climate change and what do I have to do with it?</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1330607/tab/TEAM">ENGAJAMUNDO</a>
                </p>

                <p class="contest-proposal-description">We seek to empower young Brazilians by showing them that we are part of the solution to overcome current
                    problems caused by climate change.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1331308">Low Carbon City Initiative: From Citizens To the World</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1331308/tab/TEAM">Low Carbon City Team</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1331638">Climatecoin 2016</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/shifting-behavior-for-a-changing-climate/c/proposal/1331638/tab/TEAM">Dennis Peterson</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 8 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Transportation</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/transportation/c/proposal/1329506">Mini Elevated cTrains (caterpillar trains)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/transportation/c/proposal/1329506/tab/TEAM">terrautopia</a>
                </p>

                <p class="contest-proposal-description">A comprehensive solution-mass transit for all: MINI ELEVATED cTrains: seating room only - minimal height-width-length
                    - visibly acceptable.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/transportation/c/proposal/1329506">Mini Elevated cTrains (caterpillar trains)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/transportation/c/proposal/1329506/tab/TEAM">terrautopia</a>
                </p>

                <p class="contest-proposal-description">A comprehensive solution-mass transit for all: MINI ELEVATED cTrains: seating room only - minimal height-width-length
                    - visibly acceptable.</p>
            </div>
        </div>
        <!-- Contest Accordion 9 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Waste Management</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331611">Recykle | A smart phone app to manage household waste responsibly</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331611/tab/TEAM">Kabadiwalla Connect</a>
                </p>

                <p class="contest-proposal-description">Develop a smart phone app that helps people segregate, compost, find their closest kabadiwalla and sign-up
                    for local waste management events.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331312">Conscious textile reverse Logistics</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331312/tab/TEAM">Retalhar</a>
                </p>

                <p class="contest-proposal-description">Retalhar is a social business that promotes reverse logistics of corporate uniforms by disposing it in a
                    socio-environmental friendly way.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (At Large) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331611">Recykle | A smart phone app to manage household waste responsibly</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331611/tab/TEAM">Kabadiwalla Connect</a>
                </p>

                <p class="contest-proposal-description">Develop a smart phone app that helps people segregate, compost, find their closest kabadiwalla and sign-up
                    for local waste management events.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331646">Food Recovery Network: Fighting Waste, Feeding People</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331646/tab/TEAM">FoodRecoveryNetwork</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331101">Tycycler: An intuitive, non-motorized &amp; affordable tire recycling technology</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/waste-management/c/proposal/1331101/tab/TEAM">Tycycler</a>
                </p>
            </div>
        </div>
        <!-- Partner Contest -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/ZdFe2g0.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Partner Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Aviation</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="https://lae.mit.edu/">
                        <img class="sponsor-logo" src="https://lae.mit.edu/wordpress2/wp-content/uploads/2012/06/LAE_logo_400.png"
                             style="display: none !important;" />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1331659">Strategic Investment to Scale-up Aviation Biofuel</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1331659/tab/TEAM">sunny1990</a>
                    <span> and </span>
                    <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/2484504">vmthomas1</a>
                </p>

                <p class="contest-proposal-description">Focusing heavy investments from China to ramp up sustainable biofuel production can bring global costs down.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1330302">Cross Flow Air Turbine (CFAT) Auxiliary Power Unit</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1330302/tab/TEAM">AirMach Innovations</a>
                </p>

                <p class="contest-proposal-description">Zero fuel Zero Emission replacement technology for aircraft&#39;s Auxiliary Power Units (APUs).</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1331659">Strategic Investment to Scale-up Aviation Biofuel</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1331659/tab/TEAM">sunny1990 &amp; vmthomas1</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1330302">Cross Flow Air Turbine (CFAT) Auxiliary Power Unit</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/aviation/c/proposal/1330302/tab/TEAM">AirMach Innovations</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 7 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Designing High-Density Urban Bike Parking</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="https://ecodistricts.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/F89ngZu.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2015/high-density-urban-bike-parking/c/proposal/1327506">The Flycle</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/high-density-urban-bike-parking/c/proposal/1327506/tab/TEAM">J2 for K2</a>
                </p>

                <p class="contest-proposal-description">The flycycle is efficient, accessible, easy for any organization to buy and install, and a beautiful addition
                    to street life.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2015/high-density-urban-bike-parking/c/proposal/1327506">The Flycle</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/high-density-urban-bike-parking/c/proposal/1327506/tab/TEAM">J2 for K2</a>
                </p>

                <p class="contest-proposal-description">The flycycle is efficient, accessible, easy for any organization to buy and install, and a beautiful addition
                    to street life.</p>
            </div>
        </div>
        <!-- Contest Accordion 8 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Fostering Climate Collaboration in Boulder, CO</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="https://bouldercolorado.gov">
                        <img class="sponsor-logo" src="https://i.imgur.com/uZn4tM8.png" style="display: none !important;" />
                    </a>
                    <a href="http://www.100resilientcities.org/#/-_/">
                        <img class="sponsor-logo" src="https://i.imgur.com/Orl5CpL.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2015/climate-collaboration-in-boulder-co/c/proposal/1327119">FROM CUBICLE TO CAFETERIA:Take a bite out of GHGs w/ Collaborative Green Lunches</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/climate-collaboration-in-boulder-co/c/proposal/1327119/tab/TEAM">Kira Davis, Zo&euml; Sigle</a>
                </p>

                <p class="contest-proposal-description">Drastically Reduce GHGs w/ What We Eat while Creating Collaborative Space for Climate Institutions: Plant-Based
                    Foods Produce Far Fewer GHGs</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2015/climate-collaboration-in-boulder-co/c/proposal/1327119">FROM CUBICLE TO CAFETERIA:Take a bite out of GHGs w/ Collaborative Green Lunches</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/climate-collaboration-in-boulder-co/c/proposal/1327119/tab/TEAM">Kira Davis, Zo&euml; Sigle</a>
                </p>

                <p class="contest-proposal-description">Drastically Reduce GHGs w/ What We Eat while Creating Collaborative Space for Climate Institutions: Plant-Based
                    Foods Produce Far Fewer GHGs</p>
            </div>
        </div>
        <!-- Contest Accordion 6 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Harnessing the Power of MIT Alumni</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="https://climateaction.mit.edu/updates/updates-climate-action-mit">
                        <img class="sponsor-logo" src="https://i.imgur.com/Kxvoi1W.png" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2015/harnessing-the-power-of-mit-alumni/c/proposal/1326102">ClimateX</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/harnessing-the-power-of-mit-alumni/c/proposal/1326102/tab/TEAM">MITACAL</a>
                </p>

                <p class="contest-proposal-description">ClimateX is a platform where MIT Alumni can learn climate-related science, technology and policy while transitioning
                    into a green career.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2015/harnessing-the-power-of-mit-alumni/c/proposal/1326102">ClimateX</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/harnessing-the-power-of-mit-alumni/c/proposal/1326102/tab/TEAM">MITACAL</a>
                </p>

                <p class="contest-proposal-description">ClimateX is a platform where MIT Alumni can learn climate-related science, technology and policy while transitioning
                    into a green career.</p>
            </div>
        </div>
        <!-- Contest Accordion 4 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Improving Firewood for Clean Cookstoves</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="">
                        <img class="sponsor-logo" src="https://i.imgur.com/r1HGv7M.jpg" style="display: none !important;" />
                    </a>
                    <a href="http://minka-dev.com/en">
                        <img class="sponsor-logo" src="https://i.imgur.com/cSQv4t3.png" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/improving-firewood-for-clean-cookstoves/c/proposal/1331613">Dry firewood needs seasoning, covered storage and a drying chimney</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/improving-firewood-for-clean-cookstoves/c/proposal/1331613/tab/TEAM">climaterescue</a>
                </p>

                <p class="contest-proposal-description">After careful seasoning and storing, use a simple drying chimney for firewood. Next generation cookstoves
                    can also be carbon-positive!</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/improving-firewood-for-clean-cookstoves/c/proposal/1331102">Smokeless gas cylinder stove with wood drier</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/improving-firewood-for-clean-cookstoves/c/proposal/1331102/tab/TEAM">saadithya</a>
                </p>

                <p class="contest-proposal-description">Modifying old unused gas cylinder into a smokeless stove for cooking, heat radiated while using it is used
                    for drying wood.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Materials Matter</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.nike.com/">
                        <img class="sponsor-logo" src="https://static.festisite.com/static/partylogo/img/logos/nike.png" style="display: none !important;"
                        />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331577">Empowering designers roles in using better sustainable material options</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331577/tab/TEAM">Team Wonder</a>
                </p>

                <p class="contest-proposal-description">Sourceseed is a curated alternative material option platform that allows designers to co-buy fabrics with
                    eachother at an affordable price.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331577">Empowering designers roles in using better sustainable material options</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331577/tab/TEAM">Team Wonder</a>
                </p>

                <p class="contest-proposal-description">Sourceseed is a curated alternative material option platform that allows designers to co-buy fabrics with
                    eachother at an affordable price.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331577">Empowering designers roles in using better sustainable material options</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331577/tab/TEAM">Team Wonder</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331402">Boro</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/materials-matter/c/proposal/1331402/tab/TEAM">Danny and Friends</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">MIT Climate Mitigation Solutions</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="https://sustainability.mit.edu/">
                        <img class="sponsor-logo" src="https://i.imgur.com/me5S7DR.png" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/mit-climate-mitigation-solutions/c/proposal/1329510">100% Net Zero Carbon Plan, 60% NZ Effectively Free, Expert Team Ready!</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/mit-climate-mitigation-solutions/c/proposal/1329510/tab/TEAM">Net Zero Foundation</a>
                </p>

                <p class="contest-proposal-description">100% Net Zero Carbon for all Buildings. MIT 60-80% NZ for free! #DivestTheCampus -- Join the #NetZeroMovement
                    to save the Planet!</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/mit-climate-mitigation-solutions/c/proposal/1331533">Building Cooling and Heating, with Solar Robotic Concentrated Thermal Collectors</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/mit-climate-mitigation-solutions/c/proposal/1331533/tab/TEAM">Lighthouse Group</a>
                </p>

                <p class="contest-proposal-description">It is economically and practically feasible, to substitute 60% of the energy we use for cooling and heating
                    our buildings with solar energy.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/mit-climate-mitigation-solutions/c/proposal/1331588">Minimizing HVAC Energy Use Through Low-cost Software-based Airflow Optimization</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/mit-climate-mitigation-solutions/c/proposal/1331588/tab/TEAM">mgevelber and 2 others</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 5 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Smart Zero Carbon Cities Challenge</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.inrs.ca/anglais">
                        <img class="sponsor-logo" src="https://i.imgur.com/KQayzlg.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331567">Interactive Business Energy and Emissions Dashboard for Cities</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331567/tab/TEAM">Climate Smart</a>
                </p>

                <p class="contest-proposal-description">Create a dashboard that allows cities to understand their business emissions by sector, business size, emissions
                    source, and track progress</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331647">My Energy Xpert: a home and small business energy management solution</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331647/tab/TEAM">energyX Solutions</a>
                </p>

                <p class="contest-proposal-description">My Energy Xpert is a SMART energy audit and monitoring app empowering people to save time, money and lower
                    their energy footprint.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (At Large) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331567">Interactive Business Energy and Emissions Dashboard for Cities</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331567/tab/TEAM">Climate Smart</a>
                </p>

                <p class="contest-proposal-description">Create a dashboard that allows cities to understand their business emissions by sector, business size, emissions
                    source, and track progress</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Impact</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331647">My Energy Xpert: a home and small business energy management solution</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331647/tab/TEAM">energyX Solutions</a>
                </p>

                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Commendation for Novelty</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331567">Interactive Business Energy and Emissions Dashboard for Cities</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331567/tab/TEAM">Climate Smart</a>
                </p>
            </div>
        </div>
    </div>
    <!-- ****************** 2015 ****************** -->

    <div class="2015 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://i.imgur.com/zCdlHOB.jpg" />
            <img class="winner-icon" src="https://i.imgur.com/eV8nm4C.png" />
            <h1 class="upper image-title">Contest Winners</h1>

            <p class="image-title-sub">&amp; Awardees</p>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">23</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">550</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">37</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <!-- GRAND PRIZE WINNER -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/YwSKO89.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Grand Prize Winner</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <img class="single-winner-image" src="https://static3.businessinsider.com/image/54ee19f969bedd820f6d7e15-480/eden-full-thiel-fellow-princeton-student.jpg"
            />
            <p class="single-winner-title">Eden Full &amp; Jake Schual-Berke</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301501/phaseId/1309180/planId/1318104">SunSaluter: a low-cost, passive solar tracker that produces clean water</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/contests/2015/energy-water-nexus/phase/1309180/proposal/1318104/tab/TEAM">SunSaluter</a>
            </p>

            <p class="single-winner-description">&quot;SunSaluter&#39;s goal is to make energy and water more accessible through one simple device, and to help local
                entrepreneurs build businesses around it,&quot; they write in their proposal, &quot;at a target cost of $10 per
                SunSaluter, this could be accomplished for $66M. We believe this could be achieved by 2024.&quot;</p>
        </div>
        <!-- HONORABLE MENTIONS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/f9566RT.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Honorable Mentions</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/8h0CVJN.jpg" />
            <p class="single-winner-title">Beatriz Martinez, Romera, Dirk Heine, Goran Dominioni, Arne Pieters &amp; Susanne Gaede</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1320164">An economically and legally viable mechanism for internalizing marine emissions</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/contests/2015/transportation/phase/1309164/proposal/1320164/tab/TEAM">Ship-Emissions-Levy</a>
            </p>

            <p class="single-winner-description">Beatriz Martinez, Romera, Dirk Heine, Goran Dominioni, Arne Pieters &amp; Susanne Gaede. They proposed a mechanism
                for internalizing marine emissions that combines charging a levy on emissions from international maritime shipping,
                with a fuel levy on fuel consumption by domestic shipping.</p>
        </div>
        &nbsp;

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/87OeV5I.jpg" />
            <p class="single-winner-title">Vijnana Bharati</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301417/phaseId/1309160/planId/1318001">National campaign in India aimed to create a network of young Energy Ambassadors</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/contests/2015/shifting-attitudes--behavior/phase/1309160/proposal/1318001/tab/TEAM">Vijnana Bharati</a>
            </p>

            <p class="single-winner-description">Vijnana Bharati proposed, a national campaign on energy conservation and renewable energy in Indian schools that
                is working towards building a network of energy ambassadors. The campaign already has support from the Indian
                government, and is well on its way to fostering a more environmentally-aware generation of Indians.</p>
        </div>
        <br />
        <br />
        <a class="upper expander" onclick="expandAll(this)">expand all</a>
        <br />
        <!-- GLOBAL CONTEST -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/4CAFFOo.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Global Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Global Climate Action Plan</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1302401/planId/1323902">Solar Dollars: The World Currency to Price and Finance Carbon Mitigation</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/global-climate-action-plan/phase/1311011/proposal/1323902/tab/TEAM">Global4C.org</a>
                </p>

                <p class="contest-proposal-description">The Solar Dollar is a currency for the people: to be issued as a reward for climate mitigation and financed by
                    Green Quantitative Easing.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1302401/planId/1324201">Make Climate A Top Priority for Action by Every Global Citizen and Organization</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1302401/planId/1324201/tab/TEAM">Mobilize Now</a>
                </p>

                <p class="contest-proposal-description">Use positive messages and small incentives to mobilize citizens and private/government organizations to combat
                    climate change.</p>
            </div>
        </div>
        <!-- REGIONAL CONTEST -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/IdDP1rN.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Regional Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">United States&#39; Climate Action Plan</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2015/united-states-climate-action-plan/c/proposal/1321706">Plan to build low-carbon cities from the ground up in the United States</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2015/united-states-climate-action-plan/phase/1311118/proposal/1321706/tab/TEAM">NewCityFounders</a>
                </p>

                <p class="contest-proposal-description">A revenue neutral, steadily rising fee on GHG emissions will steer the economy to a clean energy future and establish
                    US climate leadership.</p>
            </div>
        </div>
        <!-- All CONTESTS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td>
                    <h1 class="upper icon-title">Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Adaptation</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under accordion-icon-inner-special">Judges&#39; Choice Winner &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301411/phaseId/1309136/planId/1319204">Seeding Science Knowledge by engaging local experts</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301411/phaseId/1309136/planId/1319204/tab/TEAM">Geocitizens</a>
                </p>

                <p class="contest-proposal-description">Local prioritization and testing of adaptation practices supported by a collaborative mapping tool will out scale
                    lessons learned globally.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under">Popular Choice Winner (At Large)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301411/planId/1317001">Sand Dams for Climate Change Adaptation in Ghana</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301411/planId/1317001/tab/TEAM">G4CC</a>
                </p>

                <p class="contest-proposal-description">The project aims to build six sand dams in the Upper East region of Ghana to capture and store water for domestic
                    and agricultural purposes.</p>
            </div>
        </div>
        <!-- Contest Accordion 7 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Buildings</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/phaseId/1309140/planId/1305704">3D Printing Hempcrete - The People will know what they want once they see it...</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/phaseId/1309140/planId/1305704/tab/TEAM">AFMPPA</a>
                </p>

                <p class="contest-proposal-description">Build a full size 3D Printed Hempcrete Structure to demonstrate Hemp/3D Printing as a sustainable alternative
                    to traditional construction.</p>
            </div>

            <hr class="blue-line" />
            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Special Commendation</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/planId/1320139">OpenControl Building</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/planId/1320139/tab/TEAM">Group OpenControl</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Energy Supply</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under accordion-icon-inner-special">Judges&#39; Choice Winner (tie) &amp; Popular Choice Winner (At Large)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316702">Robotic Solar Armada</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316702/tab/TEAM">Helionauts</a>
                </p>

                <p class="contest-proposal-description">Synthetic fuel produced by solar harvesting ships can accelerate the transition to renewable energy by obviating
                    an infrastructure overhaul.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under">Judges&#39; Choice Winner (tie) &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316203">Distributed Plug &amp; Play Consumer Solar Panels - Add Capacity, Shed Carbon</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316203/tab/TEAM">InSite Energy, LLC.</a>
                </p>

                <p class="contest-proposal-description">Distribute Plug &amp; Play solar panels to home owners, and apartment renters to make clean energy on site where
                    you use it.</p>
            </div>
        </div>
        <!-- Contest Accordion 6 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Energy-Water Nexus</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1319614">Tidal Pump</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1319614/tab/TEAM">Robert Tulip</a>
                </p>

                <p class="contest-proposal-description">The Tidal Pump, now at proof of concept, aims to shift large volumes of liquid in the ocean at lowest possible
                    cost using new technology.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301501/phaseId/1309180/planId/1318104">SunSaluter: a low-cost, passive solar tracker that produces clean water</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301501/phaseId/1309180/planId/1318104/tab/TEAM">SunSaluter</a>
                </p>

                <p class="contest-proposal-description">The SunSaluter is a low-cost solar panel rotator which boosts efficiency by 30% and produces four liters of clean
                    drinking water each day!</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301501/planId/1320136">Nualgi - Diatom Algae - Oxygen</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301501/planId/1320136/tab/TEAM">Nualgi-Diatom Algae</a>
                </p>

                <p class="contest-proposal-description">Diatom Algae produce about 20 to 25% of all Oxygen in the world. All the oxygen required to treat sewage can
                    be produced by Diatoms.</p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Industry</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301415/phaseId/1309152/planId/1305323">Utilizing Molecularly Imprinted Technology to Selectively Filter Pollutants</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301415/phaseId/1309152/planId/1305323/tab/TEAM">alexkrotz</a>
                </p>

                <p class="contest-proposal-description">Molecular Imprinted Polymers present a unique opportunity to make inexpensive materials that selectivly bind
                    to and filter pollutants.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301415/phaseId/1309152/planId/1320154">United States Industrial Collaboration Agency (USICA)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301415/phaseId/1309152/planId/1320154/tab/TEAM">SolarVibes</a>
                </p>

                <p class="contest-proposal-description">Removing inefficiencies of industrial innovation by facilitating collaborations and accelerating R&amp;D solutions
                    toward earlier adoption.</p>
            </div>
        </div>
        <!-- Contest Accordion 9 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Land Use: Agriculture, Forestry, Livestock</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/phaseId/1309156/planId/1315109">Integrating REDD+ and Green Economic Growth for sustainable forest landscapes</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/phaseId/1309156/planId/1315109/tab/TEAM">charlesehrhart</a>
                </p>

                <p class="contest-proposal-description">Using green economic growth to create scalable, replicable financial incentives for the sustainable management
                    of forest landscapes.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/phaseId/1309156/planId/1319009">Bamboo Air Purification</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/phaseId/1309156/planId/1319009/tab/TEAM">Joseph5Chepsoi</a>
                </p>

                <p class="contest-proposal-description">Bamboo grows in most soils, environments, climate with minimal tillage, input, care and naturally purifies the
                    air we breathe.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Special Commendation</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1320104">Vertical Hydroponic Farms feed urban communities while reducing carbon emissions</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1320104/planId/1320139/tab/TEAM">Green Guys</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1319103">An online management and finance platform for sustainable forestry projects.</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1319103/tab/TEAM">OpenForests</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1312201">The Eyes of Virunga: From Poacher to Protector</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1312201/tab/TEAM">Virunga Heroes</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1314303">YES! </a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301416/planId/1314303/tab/TEAM">A. Semeniuc</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 10 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Shifting Public Attitudes &amp; Behavior</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301417/phaseId/1309160/planId/1320156">Unleash the energy of millions by making climate action simple, relevant and fun</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301417/phaseId/1309160/planId/1320156">Dylan H + Quentin P</a>
                </p>

                <p class="contest-proposal-description">It&#39;s 2050 and your granddaughter, Ohno, is suffering. Your climate action today will change her world and
                    transform her life for the better.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301417/phaseId/1309160/planId/1318001">National campaign in India aimed to create a network of young Energy Ambassadors</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301417/phaseId/1309160/planId/1318001/tab/TEAM">Vijnana Bharati</a>
                </p>

                <p class="contest-proposal-description">National level campaign on energy conservation and renewable energy in Indian schools, aimed at building a network
                    of Energy Ambassadors</p>
            </div>
        </div>
        <!-- Contest Accordion 5 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Transportation</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1319614">Networking Rwanda&#39;s Air Pollution Problem with Low-Cost Air Quality Sensors</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1319614/tab/TEAM">langleydew</a>
                </p>

                <p class="contest-proposal-description">Establishing a low-cost air quality sensor network in Kigali, Rwanda with publicly accessible data empowering
                    the public and policies.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie) &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1320164">An economically and legally viable mechanism for internalizing marine emissions</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1320164/tab/TEAM">Ship-Emissions-Levy</a>
                </p>

                <p class="contest-proposal-description">Making polluters pay for climate damage caused by maritime emissions by overcoming avoidance, legal, data and
                    global coordination issues.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">U.S. Carbon Price</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper"> Popular Choice Winner </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2014/us-carbon-price/c/proposal/2802">The Little Engine That Could: Revenue Neutral Carbon Fee and Dividend</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2014/us-carbon-price/c/proposal/2802/tab/TEAM">NewCityFounders</a>
                </p>

                <p class="contest-proposal-description">Low-carbon cities can be engineered and built today for livability, sustainability, resiliency, energy-efficiency
                    and affordability</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Special Commendation</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301419/planId/2802">The Little Engine That Could: Revenue Neutral Carbon Fee and Dividend</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301419/planId/2802/tab/TEAM">CitizensClimateLobby</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301419/planId/1319612">Sweeten the Carbon Deal</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301419/planId/1319612/tab/TEAM">billferree</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301419/planId/1320193">Novel Strategy On Private Sector&rsquo;s Internal/&rdquo;Shadow&rdquo; Carbon Pricing</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301419/planId/1320193/tab/TEAM">kathoh</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 8 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Waste Management</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/phaseId/1309140/planId/1305704">fulFILL: A delivery service for household products without wasteful packaging</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/phaseId/1309140/planId/1305704/tab/TEAM">fulFILL</a>
                </p>

                <p class="contest-proposal-description">fulFILL aims to combat the waste epidemic by revolutionizing the way we consume common household products.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301420/phaseId/1309172/planId/1320133">Nualgi - Diatom Algae for Sewage Treatment</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301420/phaseId/1309172/planId/1320133/tab/TEAM">Nualgi-Diatom Algae</a>
                </p>

                <p class="contest-proposal-description">Using Nualgi to grow Diatoms is the most economical and sustainable solution to sewage treatment,growing fish
                    and fuel and sequester carbon.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301420/planId/1314910">GHG Rescue; Buying Waste from Households and selling it to Recycle Companies </a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301420/planId/1314910/tab/TEAM">G4CC</a>
                </p>

                <p class="contest-proposal-description">The GHG Rescue Project seeks to buy segregated waste from households in Accra, Ghana and sell it to Recycling
                    Companies.</p>
            </div>
        </div>
        <!-- PARTNER CONTERSTS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/ZdFe2g0.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Partner Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Anticipating Climate Change in the Pamir Mountains</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://thrivingearthexchange.org/">
                        <img class="sponsor-logo" src="/image/contest_sponsor?img_id=1244308" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner (tie) </span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301102/phaseId/1308611/planId/1317202">Linking Climate Information to Ecological Calendars: An Appointment With Drought</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301102/phaseId/1308611/planId/1317202/tab/TEAM">mattbarlow</a>
                </p>

                <p class="contest-proposal-description">Prepare for climate change and apply regional drought information in the Pamirs by linking climate science with
                    human ecological calendars.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> Popular Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301102/phaseId/1308611/planId/1313605">Biodiversity collections as tools for understanding changes in the Pamir Mtns</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/1240113">ellwood</a>
                </p>

                <p class="contest-proposal-description">Anticipate and adapt to changing phenological patterns in the Pamir Mtns through the use of historical and contemporary
                    biodiversity data.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under">Judges&#39; Choice Winner (tie) &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301102/phaseId/1308611/planId/1316301">Recalibration of traditional calendars through participatory data collection</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/1452017">TedW</a>
                </p>

                <p class="contest-proposal-description">Traditional knowledge, participatory science, and modern data analytics to create climate- smart, farm-scale
                    agricultural body calendars</p>
            </div>
        </div>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Atypical Ideas For Carbon Neutrality</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.somervillema.gov/">
                        <img class="sponsor-logo" src="https://www.climatecolab.org/image/contest_sponsor?img_id=1244316" style="display: none !important;"
                        />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/phaseId/1309202/planId/1320163">Sustainable Urban Food Initiative (SUFI) for Climate Change Resilience</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/phaseId/1309202/planId/1320163/tab/TEAM">PlaneTiers</a>
                </p>

                <p class="contest-proposal-description">SUFI provides an integrated hub that sustainably manages the urban energy-water-food nexus in an era of climate
                    change.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/phaseId/1309202/planId/1317902">The Loop Transit System</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/phaseId/1309202/planId/1317902/tab/TEAM">SomClimateAction</a>
                </p>

                <p class="contest-proposal-description">The Loop transit system is a fleet of fare-based passenger vehicles that travel planned route within city limits
                    on a continuous schedule.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/phaseId/1309202/planId/1315101">CarbonGobbler - Engaging Citizens And Business In Lowering Carbon Emissions</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/phaseId/1309202/planId/1315101/tab/TEAM">CarbonGobbler</a>
                </p>

                <p class="contest-proposal-description">Manage and Control Carbon Emission biggies, energy use and transportation choices with CarbonGobbler. While saving
                    money too.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header-special">
                    <span class="upper contest-title-under-special">Judges&#39; Special Commendation</span>
                </div>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1319915">Just Green It &ndash; Purchasing Electricity from Renewable Sources for Somerville</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1319915/tab/TEAM">IdeatingGreen</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1320128">Urban Wood: Somerville&rsquo;s Wood Construction Legacy and Future Carbon Neutrality</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1320128/tab/TEAM">Team Urban Wood</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1315101">CarbonGobbler &ndash; Engaging Citizens And Business In Lowering Carbon Emissions</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1315101/tab/TEAM">CarbonGobbler</a>
                </p>

                <p class="contest-proposal-special">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1317902">The Loop Transit System</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301402/planId/1317902/tab/TEAM">SomClimateAction</a>
                </p>
            </div>
        </div>
        <!-- Contest Accordion 4 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Energy Solutions For Latin America</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://mitsloan.mit.edu/office-of-international-programs/mit-sloan-latin-america-office/">
                        <img class="sponsor-logo" src="https://i.imgur.com/ZlWqqcQ.png" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301408/phaseId/1309148/planId/1317205">Electricity at the lowest societal cost: holistic optimization</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301408/phaseId/1309148/planId/1317205/tab/TEAM">EMERGE</a>
                </p>

                <p class="contest-proposal-description">Electricity at the lowest societal cost by optimizing techno-economic, environmental and health impacts of electricity
                    infrastructure growth.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301408/phaseId/1309148/planId/1320144">Establish Local Energy Interaction Strategies (LEIS) as driver to GHG reductions</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301408/phaseId/1309148/planId/1320144/tab/TEAM">G4 Energ&iacute;a</a>
                </p>

                <p class="contest-proposal-description">Highly replicable solution for Latin America reality based on local energy interaction strategy to create a win-win
                    network to GHG reduction.</p>
            </div>
        </div>
        <!-- Contest Accordion 4 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Rural Resilience</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.uc.edu/">
                        <img class="sponsor-logo" src="https://i.imgur.com/nNK4CBx.jpg" style="display: none !important;" />
                    </a>
                    <a href="http://en.bjtu.edu.cn/">
                        <img class="sponsor-logo" src="https://i.imgur.com/XM0biGt.png" style="display: none !important;" />
                    </a>
                    <a href="http://co.clinton.oh.us/government/regional-planning-commission/">
                        <img class="sponsor-logo" src="https://i.imgur.com/d1VEKaq.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301502/phaseId/1309176/planId/1319004">China&#39;s rural-urban intensification. Envisioning the habitat of the future</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301502/phaseId/1309176/planId/1319004/tab/TEAM">tcatta</a>
                </p>

                <p class="contest-proposal-description">Design strategies to improve resilience of China&acirc;&euro;&trade;s rural towns. Envisioning harmonious relationship
                    between the rural and urban environments.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301502/phaseId/1309176/planId/1314414">Generation of Biogas energy from animal waste for use in rural areas</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301502/phaseId/1309176/planId/1314414/tab/TEAM">asigealex</a>
                </p>

                <p class="contest-proposal-description">The use of Biogas energy from animal waste is a sustainable source of energy to meet the domestic energy demands
                    for cooking and lighting.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Urban Energy Efficiency</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.negawattchallenge.com/about/">
                        <img class="sponsor-logo" src="https://i.imgur.com/IbsII9m.png" style="height: 60px; display: none !important;"
                        />
                    </a>
                    <a href="http://www.worldbank.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/PDqojGy.png" style="height: 60px; display: none !important;"
                        />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner &amp; Popular Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301603/phaseId/1309184/planId/1320165">Making every watt count: An intelligent demand side management system on phones</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301603/phaseId/1309184/planId/1320165/tab/TEAM">Energy-Save (Esave)</a>
                </p>

                <p class="contest-proposal-description">A smart energy audit on consumers&acirc;&euro;&trade; phones displaying their real time electricity consumption,
                    wastage sources n tips to reduce energy use.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301603/planId/1319615">Pedal power</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301603/planId/1319615/tab/TEAM">New Latin America</a>
                </p>

                <p class="contest-proposal-description">An initative thar reduce green house gases emissions; while you generate electricity, get a healthier life and
                    reduce vehicular traffic.</p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Urban Heat Island Effect</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.cambridgema.gov/">
                        <img class="sponsor-logo" src="https://www.climatecolab.org/image/contest_sponsor?img_id=1244316" style="height: 60px; display: none !important;"
                        />
                    </a>
                    <a href="http://www.worldbank.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/PDqojGy.png" style="height: 60px; display: none !important;"
                        />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner &amp; Popular Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313914">Cold Spot: Evaporative Cooling through Ceramics</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313914/tab/TEAM">ceramics</a>
                </p>

                <p class="contest-proposal-description">Designing an oasis in the heat island of Cambridge.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313904">Cooling with Urban-Ecosystem Services</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313904/tab/TEAM">Biomimicry NE</a>
                </p>

                <p class="contest-proposal-description">FIGHT urban heat island effect like a forest. Capture water, filter light, and evaporate to keep cool.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313802">Variations on the Velarium </a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313802/tab/TEAM">Michael D Newton</a>
                </p>

                <p class="contest-proposal-description">Apply ancient Roman invention (the velarium) imbedded w/thin-film solar cells above urban hot spots to disrupt
                    heat island effect.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313606">White Knights</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313606/tab/TEAM">minkavb</a>
                </p>

                <p class="contest-proposal-description">Lighten all municipal parking lot surface temps with white paint &amp; healthy tree boats</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313102">Depave driveways and increase rain barrel irrigation</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2014/urban-heat-island-effect/c/proposal/1313102/tab/TEAM">qyz</a>
                </p>

                <p class="contest-proposal-description">Depave driveways to decrease urban heating!</p>
            </div>
        </div>
    </div>
    <!-- ****************** 2014 ****************** -->

    <div class="2014 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://lh3.googleusercontent.com/-9VMBJoZbfPk/VH-jzaf_OqI/AAAAAAAAB8A/eQT6OpMdCHc/w1624-h1082-no/20141105_DR19546A.jpg"
            />
            <!-- <img class="image-title" src="http://image.flaticon.com/teams/1-freepik.jpg"> -->
            <img class="winner-icon" src="https://i.imgur.com/gIkpDwC.png" />
            <h1 class="upper image-title">Contest Winners</h1>

            <p class="image-title-sub">&amp; Awardees</p>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">18</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">582</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">34</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <!-- GRAND PRIZE WINNER -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/YwSKO89.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Grand Prize Winner</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <div style="float: left; height: 143px;">
                <img class="single-winner-image" src="https://i.imgur.com/yctNVxk.jpg" />
            </div>

            <p class="single-winner-title">Danielle Dahan</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300203/planId/1309346">Improve Building Energy Performance: Green Job Skills Training</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/1504027">danielledahan</a>
            </p>

            <p class="single-winner-description">&ldquo;&quot;As high performance green buildings increase in complexity,&quot; Dahan writes in her proposal, &quot;we
                need to give building technicians the skills to maintain buildings and achieve high performance energy goals.&quot;
                The curriculum, when in full motion, is projected to save 111 million metric tons of carbon each year in the
                United States alone.</p>
        </div>
        <!-- HONORABLE MENTIONS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/f9566RT.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Honorable Mentions</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/99cqCOQ.jpg" />
            <p class="single-winner-title">Adele Morris</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300404/planId/1307606">A Carbon Tax in Pro-Growth Fiscal Reform</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/1423255">adelemorris</a>
            </p>

            <p class="single-winner-description">Adele Morris is a fellow and policy director of the Climate and Energy Economics Project at the Brookings Institution.
                She proposed a carbon tax that creates pro-growth tax reform, while also protecting the poor and reducing the
                deficit.</p>
        </div>
        &nbsp;

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/M8HzH45.png" />
            <p class="single-winner-title">Anne-Marie Soulsby and Mandolin Dotto Kahindi</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300801/planId/1309001">A Collaborative Solutions Communication Platform</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300801/planId/1309001/tab/Team">jlgula</a>
            </p>

            <p class="single-winner-description">The proposal presents Tunza Kwa Faida (Benefits for All), a platform that combines a radio show and two-way text
                messaging to help coastal Tanzanians increase their resilience to climate change.</p>
        </div>
        &nbsp;

        <div class="single-winner">
            <img class="single-winner-image" src="https://www.climatecolab.org/image/user_male_portrait?screenName=jtam&amp;companyId=10112&amp;portraitId=1441489&amp;userId=1441489"
            />
            <p class="single-winner-title">Job Taminiau, Gordon Schweitzer, Kathleen Saul and Sardar Mohazzam</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/contests/2016/the-smart-zero-carbon-cities-challenge/c/proposal/1331647">Democratic Finance: Energy Of the People, By the People, For the People</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/2469674">alex7728</a>
            </p>

            <p class="single-winner-description">The group from the United States, Netherlands, and Pakistan proposed installing community-funded solar projects on
                unused federal rooftop space, which, they predict could mitigate millions of tons of CO2 emissions.</p>
        </div>
        <br />
        <br />
        <a class="upper expander" onclick="expandAll(this)">expand all</a>
        <br />
        <!-- GLOBAL CONTEST -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/4CAFFOo.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Global Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion-->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Global Plan</span>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under"> Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300701/planId/1308202">Settle the carbon debt and release the power of example!</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300701/planId/1308202/tab/TEAM">Jan Kunnas</a>
                </p>

                <p class="contest-proposal-description">I suggest how to leave the dispute about historical responsibility for climate change behind and unleash the
                    power of example.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under">Judges&#39; Choice (tie) &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300701/planId/1309401">Carbon-Free, Fast</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1302401/planId/1324201/tab/TEAM">Dennis Peterson</a>
                </p>

                <p class="contest-proposal-description">An aggressive approach that doesn&#39;t break the bank.</p>
            </div>
        </div>
        <!-- All CONTESTS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td>
                    <h1 class="upper icon-title">Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Adaptation</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under accordion-icon-inner-special">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316702">Stop Groundwater Plan - Save $8 Billion</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316702/tab/TEAM">Majdi &amp; Manaugh</a>
                </p>

                <p class="contest-proposal-description">Systems thinking leads to a regional desalination plan to replace a narrowly conceived, costly and destructive
                    groundwater pumping plan.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300208/planId/1309103">Future mangroves</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300208/planId/1309103/tab/TEAM">Poh Poh Wong</a>
                </p>

                <p class="contest-proposal-description">Mangroves to address sea level rise and coastal erosion.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under accordion-icon-inner-special">Judges&#39; Choice (tie) &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316702">Municipal adaptation strategy to climate change in Costa Rica</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301413/phaseId/1309144/planId/1316702/tab/TEAM">Sergio A. Molina-Murillo</a>
                </p>

                <p class="contest-proposal-description">Implementation of climate strategy at Municipal level by empowering and training local actors with focus on agriculture
                    and water resources.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Buildings</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301415/phaseId/1309152/planId/1305323">COFA: Climate Optimized Fenestrations for Buildings in Developing Nations</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301415/phaseId/1309152/planId/1305323/tab/TEAM">Prof. Pradeep Kini</a>
                </p>

                <p class="contest-proposal-description">Climate adaptive energy conserving commercial building envelopes with analytical tool COFA:Climate Optimized
                    Fenestration Assembly.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300203/planId/1309346">Improve Building Energy Performance: Green Job Skills Training</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300203/planId/1309346/tab/TEAM">Danielle Dahan</a>
                </p>

                <p class="contest-proposal-description">As high performance green buildings increase in complexity, technicians need the skills to maintain buildings
                    and achieve energy goals.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300203/planId/1307411">Passive Architectural Design Index: A benchmark for passive building techniques</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300203/planId/1307411/tab/TEAM">Sriraj Gokarakonda</a>
                </p>

                <p class="contest-proposal-description">Unless sufficiency is addressed with same rigour as efficiency, energy usage is inadvertently increased resulting
                    in a rebound effect.</p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Consumption of Products &amp; Services</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org:18081/plans/-/plans/contestId/1300207/planId/1307305">Food bikes: the low capital, low footprint alternative to food trucks</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org:18081/plans/-/plans/contestId/1300207/planId/1307305/tab/TEAM">John Romankiewicz</a>
                </p>

                <p class="contest-proposal-description">Food bikes are the low capital, low footprint alternative to food trucks, bringing positive economic and community
                    development.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300207/planId/1309101">Grocery Carbon-Coloured Shelving</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300207/planId/1309101/tab/TEAM">Hannah Ritchie</a>
                </p>

                <p class="contest-proposal-description">Design a coloured shelving system for grocery products based on carbon footprint,to help consumers make better-informed
                    choices.</p>
            </div>
        </div>
        <!-- Contest Accordion 4 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Crowdsourcing for Disaster Risk Management</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300402/planId/1308206">&quot;Save the Baby&quot; Global Data Commons for Baby Care</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300402/planId/1308206/tab/TEAM">Chika Kuroda</a>
                </p>

                <p class="contest-proposal-description">Save the Baby: Global Data Commons created by digitized maternal and infant health record for disaster risk management.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300402/planId/1307109">We Are Ready (WAR)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300402/planId/1307109/tab/TEAM">Pooran Prasad Rajanna </a>
                </p>

                <p class="contest-proposal-description">We Are Ready is a platform to crowd source disaster info, send disaster alerts, plan evacuation, track people
                    &amp; identify medical needs.</p>
            </div>
        </div>
        <!-- Contest Accordion 5 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Energy Supply</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1319614">Turn your phone into a virtual power plant and get paid to optimize your energy.</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301418/phaseId/1309164/planId/1319614/tab/TEAM">Matt Duesterberg</a>
                </p>

                <p class="contest-proposal-description">Pay people to use less electricity at key moments when their energy is coming from the grid&#39;s most carbon-intensive
                    power plants.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <hr class="blue-line" />
                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300201/planId/1307701">Path To Zero - Energy Supply</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300201/planId/1307701/tab/TEAM">BAS Nederland, Arash Aazami</a>
                </p>

                <p class="contest-proposal-description">Bring cities to energy independence through carbon, energy and cost neutrality.</p>
            </div>
        </div>
        <!-- Contest Accordion 6 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Industry</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300204/planId/1309035">STRAUT Aero: Solar Hot Air Generator</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300204/planId/1309035/tab/TEAM">STRAUT, Sharad Parekh</a>
                </p>

                <p class="contest-proposal-description">STRAUT AERO Innovative design solar hot air gen. massive potential 4 addressng industrial process heat req. economic
                    wthout subsidies.</p>
            </div>
        </div>
        <!-- Contest Accordion 7 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Land Use: Agriculture, Livestock &amp; Forestry</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/phaseId/1309140/planId/1305704">fulFILL: A delivery service for household products without wasteful packaging</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301412/phaseId/1309140/planId/1305704/tab/TEAM">fulFILL</a>
                </p>

                <p class="contest-proposal-description">fulFILL aims to combat the waste epidemic by revolutionizing the way we consume common household products.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; (tie) &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300205/planId/1309102">Synergies of Reforestation &amp; Community Empowerment in Kenya</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300205/planId/1309102/tab/TEAM">The Kijani Team, Tobias Lohse</a>
                </p>

                <p class="contest-proposal-description">Reforestation as convergence of climate change mitigation and adaptation with socioeconomic well-being and ecological
                    restoration.</p>
            </div>
        </div>
        <!-- Contest Accordion 8 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Shifting Behavior for a Changing Climate</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301603/phaseId/1309184/planId/1320165">Visualizing climate-changed futures with serious play</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1301603/phaseId/1309184/planId/1320165/tab/TEAM">FutureCoast, Ken Eklund</a>
                </p>

                <p class="contest-proposal-description">FutureCoast: a fun storymaking game with voicemails leaked from climate-changed futures. They appear in our time
                    as mysterious chronofacts.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300210/planId/1309350">Fossil fuel divestment: Building a social movement for collective climate action</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300210/planId/1309350/tab/TEAM">Fossil Free MIT, Geoffrey Supran</a>
                </p>

                <p class="contest-proposal-description">Fossil fuel divestment campaigns shift public opinion, empower young organizers, and generate sociopolitical
                    willpower for climate action.</p>
            </div>
        </div>
        <!-- Contest Accordion 9 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Transportation</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300202/planId/1308411">Batteries on the move for a more efficient world</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300202/planId/1308411/tab/TEAM">Lance Noel of eRev</a>
                </p>

                <p class="contest-proposal-description">eRev finances V2G-capable electric vehicles so they provide grid storage, generate revenue, and cost less than
                    traditional vehicles.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300202/planId/1305317">Pollution meter</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300202/planId/1305317/tab/TEAM">Shenbagarajan Pandiarajan</a>
                </p>

                <p class="contest-proposal-description">Pollution prediction meter in automobiles &amp; display panels over the roads + Emissions trading.</p>
            </div>
        </div>
        <!-- Contest Accordion 10 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">U.S. Carbon Price</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300404/planId/1305801">Sno-Caps: The People&#39;s Cap-And-Trade</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300404/planId/1305801">Sno-Caps Team, James D&#39;Angelo</a>
                </p>

                <p class="contest-proposal-description">Employing a new form of scalable regulation, we can launch a global cap-and-trade today that sidesteps politics
                    and incentivizes the masses.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300404/planId/1307606">A Carbon Tax in Pro-Growth Fiscal Reform</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300404/planId/1307606/tab/TEAM">Adele Morris</a>
                </p>

                <p class="contest-proposal-description">Use a carbon tax for pro-growth tax reform, protecting the poor, deficit reduction, and reducing less efficient
                    policies.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2014/us-carbon-price/c/proposal/2802">The Little Engine That Could: Revenue Neutral Carbon Fee and Dividend</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2014/us-carbon-price/phase/1309169/proposal/2802/tab/TEAM">CitizensClimateLobby</a>
                </p>

                <p class="contest-proposal-description">A revenue neutral, steadily rising fee on GHG emissions will steer the economy to a clean energy future and establish
                    US climate leadership.</p>
            </div>
        </div>
        <!-- Contest Accordion 11 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Waste Management</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300206/planId/1304909">REACC (RECYCLED DEBRIS FOR ADAPTATION TO CLIMATE CHANGE)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300206/planId/1304909/tab/TEAM">Victor Blanco</a>
                </p>

                <p class="contest-proposal-description">Cement Production is the 4th global fossil carbon emission activity and it&Acirc;&acute;s time to reduce and
                    recycle debris for healthy environment.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300206/planId/1002">Using Biogas Technology To Improve Sanitation And Mitigate Climate Change</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300206/planId/1002/tab/TEAM">Osero Shadrack Tengeya</a>
                </p>

                <p class="contest-proposal-description">Uncontrolled greenhouse gas emission from sewage waste will be reduced by using simple technology like utilizing
                    this waste in making biogas.</p>
            </div>
        </div>
        <!-- PARTNER CONTERSTS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/ZdFe2g0.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Partner Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Communicating Coastal Risk and Resilience</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.noaa.gov/">
                        <img class="sponsor-logo" src="https://www.climatecolab.org/image/contest_sponsor?img_id=1217638" style="display: none !important;"
                        />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300801/planId/1309001">A collaborative solutions communication platform</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300801/planId/1309001/tab/TEAM">Anne-Marie Soulsby </a>
                </p>

                <p class="contest-proposal-description">Solutions platform users collaboratively share adaptations to improve livelihoods &amp; increase coastal Tanzanian&#39;s
                    climate change resilience.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300801/planId/1309316">The world according to CLIVE (CoastaL Impact Visualization Environment)</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300801/planId/1309316/tab/TEAM">Adam Fenech</a>
                </p>

                <p class="contest-proposal-description">CLIVE allows citizens to visualize 3D sea-level rise and storm surge scenarios at local community scales using
                    past data and IPCC models.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Creating Public Demand for Green Building</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.worldgbc.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/SbChuhP.png" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner &amp; Judges&#39; Special Commendation</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300403/planId/1307702">Path To Zero - Transforming energy inefficient buildings to green buildings</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300403/planId/1307702/tab/TEAM">BAS Nederland, Arash Aazami</a>
                </p>

                <p class="contest-proposal-description">Bring cities to energy independence through carbon, energy and cost neutrality.</p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Urban Resilience: Climate Actions for Urban Areas</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.icleiusa.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/2kpBGmW.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300501/planId/1308413">GreenUp - Engaging communities to build green &amp; resilient cities in India </a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300501/planId/1308413/tab/TEAM">Aditi Sen</a>
                </p>

                <p class="contest-proposal-description">A crowdsourcing platform that provides funds and educational resources to encourage adoption of green infrastructure
                    practices in cities.</p>
            </div>
        </div>
        <!-- Contest Accordion 4 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">U.S. Government</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.thirdway.org/">
                        <img class="sponsor-logo" src="https://www.climatecolab.org/image/contest?img_id=1213920" style="display: none !important;"
                        />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300401/planId/1307119">Democratic Finance: Energy Of the People, By the People, For the People</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300401/planId/1307119/tab/TEAM">The Energy Commons, Job Taminiau</a>
                </p>

                <p class="contest-proposal-description">A people-funded green energy revolution that reconnects people to energy and repositions the US as a global leader.</p>
            </div>
        </div>
        <!-- Contest Accordion 5 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Youth Action on Climate Change</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://theelders.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/SSzBmHQ.png" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300901/planId/1307405">Climate Change is Elementary: Huge Green Fundraiser for Schools</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300901/planId/1307405/tab/TEAM">Dave Finnigan</a>
                </p>

                <p class="contest-proposal-description">Kids promote the program. Vendors selling green products automatically give discounts to parents and rebates
                    to PTAs for family purchases.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">&lt;
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Special Commendation</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300901/planId/1308907">Make Our Economic Reasoning Consistent with Intergenerational Justice</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300901/planId/1308907/tab/TEAM">Timothy Damon</a>
                </p>

                <p class="contest-proposal-description">Empower youth to advocate for a just valuation of their future in the economics of climate change, thus unlocking
                    ambitious climate action.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300901/planId/1310207">Indicators for Sustainability</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1300901/planId/1310207/tab/TEAM">TierraVida, Marina Mansilla Hermann</a>
                </p>

                <p class="contest-proposal-description">Building a youth-led citizen movement to address climate change from the bottom-up.</p>
            </div>
        </div>
    </div>
    <!-- ****************** 2013 / 2012 ****************** -->

    <div class="2013 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://lh4.googleusercontent.com/-tM7m27Qf7LM/UoPRwcHOFEI/AAAAAAAAA5I/lWxM5iWcYNk/w1624-h1082-no/20131106DR0582.jpg"
            />
            <!-- <img class="image-title" src="http://image.flaticon.com/teams/1-freepik.jpg"> -->
            <img class="winner-icon" src="https://i.imgur.com/4wHQcVR.png" />
            <h1 class="upper image-title">Contest Winners</h1>

            <p class="image-title-sub">&amp; Awardees</p>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">18</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">374</p>

                <p class="stat-bubble-title upper">Submissions</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">28</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <!-- GRAND PRIZE WINNER -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/YwSKO89.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Grand Prize Winner</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/30gug6R.jpg" />
            <p class="single-winner-title">Dr. Geoffrey Hay and the HEAT team</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/contests/2012/reducing-consumption/c/proposal/1304134">Whose Home is wasting more energy, yours or your neighbours?</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/member/-/member/userId/1243638">drgeoff</a>
            </p>

            <p class="single-winner-description">&quot;We&#39;re excited about being recognized and having our work recognized, but we&#39;re also excited about the
                other proposals we&#39;ve been in the company of. There were some outstanding proposals, and we&#39;re grateful
                to have been part of that group&quot;, says Hay in a thank you
                <a href="http://www.youtube.com/watch?v=pGPxDGiUIYA">video</a>.</p>
        </div>
        <!-- HONORABLE MENTIONS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/f9566RT.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Honorable Mentions</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="single-winner">
            <img class="single-winner-image" src="https://i.imgur.com/HR2gvqI.jpg" />
            <p class="single-winner-title">Peggy Liu and Chenyu Zheng</p>

            <p class="single-winner-proposal">
                <a href="https://www.climatecolab.org/contests/2012/reducing-consumption/c/proposal/1304131">Reimagine prosperity; reframe sustainability; reshape consumerism</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/contests/2012/reducing-consumption/c/proposal/1304131/tab/team">JUCCCE</a>
            </p>

            <p class="single-winner-description">JUCCCE (Joint US-China Collaboration on Clean Energy), a Shanghai-based non-profit organization, were awarded an
                Honorable Mention for their proposal, &quot;Reimagine prosperity; reframe sustainability; reshape consumerism&quot;.
                Their &quot;China Dream&quot; project seeks to develop a new, more sustainable vision of the good life for the
                growing Chinese middle class.</p>
        </div>
        <br />
        <br />
        <a class="upper expander" onclick="expandAll(this)">expand all</a>
        <br />
        <!-- All CONTESTS -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td>
                    <h1 class="upper icon-title">Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Adaptation by Civil Society Winners</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/19/planId/1304113">George Hops Farmers Association Climate Adaptation &amp; Resilience Programme</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/19/planId/1304113/tab/TEAM">Victor Blanco</a>
                </p>

                <p class="contest-proposal-description">Hops production is threatened by climate change. Farmers must adapt to secure the benefits of their enterprise.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/19/planId/1304112">Steps to an Ecology of Mind -- Climate Change Impact/Adaptation Strategy in Africa</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/19/planId/1304112/tab/TEAM">AHP/FPD: Monika dos Santos</a>
                </p>

                <p class="contest-proposal-description">Africa contributes the least of any continent to global warming. People living on the continent are in line to
                    be the hardest hit.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Agriculture &amp; Forestry</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/18/planId/1304144">Nicaragua: Carbon Sink, Economic Driver &amp; Medicinal Plant Preservation</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/18/planId/1304144/tab/TEAM">Cecalli Esteli - Pia Jensen and Alejandro Floripe</a>
                </p>

                <p class="contest-proposal-description">Poverty stricken &amp; war torn, Nicaragua&#39;s people strive for healthy environs &amp; Cecalli has ambitious
                    plans to improve life via reforestation.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/18/planId/1304144">Woody Agriculture: Breeding &amp; Implementing Hazelnut &amp; Chestnut as Staple Crops </a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/18/planId/1304144/tab/TEAM">Badgersett Research</a>
                </p>

                <p class="contest-proposal-description">Woody Agriculture converts annual cropland to staple-food-producing woody plants, capturing 3 times the carbon.
                    It&#39;s time to scale it up.</p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Building Efficiency</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice and Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/11/planId/1304139">EE-based Formalization</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/11/planId/1304139/tab/TEAM">UNDP Montenegro</a>
                </p>

                <p class="contest-proposal-description">Using energy efficiency as an incentive for formalization of illegal buildings in Montenegro.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/11/planId/1304140">Smart LED Streetlamps system through the implementation of mesh networks</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/11/planId/1304140/tab/TEAM">Hector Bracamontes</a>
                </p>

                <p class="contest-proposal-description">Streetlamps are part of the city&#39;s street furniture. Their electricity consumption represents a high percentage
                    of a small-size city budget.</p>
            </div>
        </div>
        <!-- Contest Accordion 4 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Electric Power Sector</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/10/planId/1304174">Spontaneous Conversion of Power Plant CO2 to Dissolved Calcium Bicarbonate</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/10/planId/1304174/tab/TEAM">Greg Rau, Ken Caldeira and Phil Renforth</a>
                </p>

                <p class="contest-proposal-description">As in SO2 mitigation, spontaneously remove CO2 from power plant flue gas using wet limestone scrubbing.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/10/planId/1304170">Integral Fast Reactors Can Power The Planet</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/10/planId/1304170/tab/TEAM">Tom Blees</a>
                </p>

                <p class="contest-proposal-description">Mass-producible integral fast reactor modules can power every country on earth for nearly a millennium with waste
                    products already at hand.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner (At Large)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/10/planId/1304168">It&#39;s the 21st Century. Where&#39;s My Fusion Reactor?</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/10/planId/1304168tab/TEAM">Dennis Peterson</a>
                </p>

                <p class="contest-proposal-description">Cheap, practical fusion may be closer than you think.</p>
            </div>
        </div>
        <!-- Contest Accordion 5 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Enabling Adaptation</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice and Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/22/planId/1304128">Building consensus, enabling adaptation: facilitating collective risk management</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/22/planId/1304128/tab/TEAM">Danya Rumore, Lawrence Susskind, Patrick Field, and Carri Hulet</a>
                </p>

                <p class="contest-proposal-description">Here&#39;s a collaborative approach that at-risk communities can use to move forward with adaptation. Help us
                    implement it!</p>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner (At Large) and Judges&#39; special commendation</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/22/planId/1304129">Photovoice for Vulnerability: Disaster Adaptation in Central Philippines</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/22/planId/1304129/tab/TEAM">Yanjun Cai</a>
                </p>

                <p class="contest-proposal-description">Empower the disadvantaged community through participatory photography to reveal unheard vulnerability and form
                    adaptation capacity.</p>
            </div>
        </div>
        <!-- Contest Accordion 6 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Geoengineering</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/20/planId/1304119">Saving the Planet, v2.0</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/20/planId/1304119/tab/TEAM">Greg Rau, Ken Caldeira, and Max Platzer</a>
                </p>

                <p class="contest-proposal-description">Interested in air CO2 removal, carbon-negative fuel, saving the ocean, and redrawing the global energy map?</p>
            </div>
        </div>
        <!-- Contest Accordion 7 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Reducing Consumption</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie) and Climate CoLab Grand Prize Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/25/planId/1304134">Whose Home is wasting more energy, yours or your neighbours?</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/25/planId/1304134/tab/team">Geoff Hay</a>
                </p>

                <p class="contest-proposal-description">FREE personalized HEAT Scores, HEAT Maps, Hot Spots, GHG estimates and waste-heat comparisons/competitions for
                    homes, communities &amp; cities.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/25/planId/1304133">Cool Food - empowering climate friendly food choices on a daily basis</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/25/planId/1304133/tab/TEAM">Cool Food </a>
                </p>

                <p class="contest-proposal-description">Team members: Viv Baker, Gerard Bisshop, Diana Donlon, and Francesca Allievi. A &quot;Cool Food&quot; rating
                    system indicating climate and other impacts would empower consumers to choose climate-friendly foods.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner and Climate CoLab Honorable Mention</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/contests/2012/reducing-consumption/c/proposal/1304131">Reimagine prosperity; reframe sustainability; reshape consumerism</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/contests/2012/reducing-consumption/c/proposal/1304131/tab/TEAM">JUCCCE</a>
                </p>

                <p class="contest-proposal-description">Use a carbon tax for pro-growth tax reform, protecting the poor, deficit reduction, and reducing less efficient
                    policies.</p>
            </div>
        </div>
        <!-- Contest Accordion 8 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Replacing Diesel Generation</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice and Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/24/planId/1304159">Replacing the use of diesel pumps in agriculture</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/24/planId/1304159/tab/TEAM">IDEI - Amitabha Sadangi</a>
                </p>

                <p class="contest-proposal-description">Replacing diesel pump use for irrigation by promoting Treadle Pumps and preparing a toolkit for capacity building.</p>
            </div>
        </div>
        <!-- Contest Accordion 9 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Scaling Renewables in Major Emerging Economies</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/23/planId/1304153">Fish River River Hydro Scheme</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/23/planId/1304153/tab/TEAM">Peter Jordaan and Magun Janietzche </a>
                </p>

                <p class="contest-proposal-description">A run-of-river hydroelectric system with a novel new approach that fundamentally differs from the standard hydro
                    methodology.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/23/planId/1304156">From the Crowd to the Base: Crowdfunding for Local Climate Action</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/23/planId/1304156/tab/TEAM">Konrad Ritter and Diann Black-Layne</a>
                </p>

                <p class="contest-proposal-description">Crowdfunding channeled through Microfinance gives urban and rural poor access to renewable energy to transform
                    lives.</p>
            </div>
        </div>
        <!-- Contest Accordion 10 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Shifting Public Perceptions on Climate Change</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under accordion-icon-inner-special">Judges&#39; Choice and Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/21/planId/1304124">Sunk Investment Map: Show the Personal Property Impacts of Climate Change</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/21/planId/1304124/tab/TEAM">Keith Brower Brown</a>
                </p>

                <p class="contest-proposal-description">Let&#39;s make climate change personal--with a map to show Americans how floods, storms and wildfire could impact
                    their homes and businesses.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under">Popular Choice Winner (At Large)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/21/planId/1304121">CliO - A Virtual Green Pet that Responds With Low-Carbon Lifestyle Choices</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/21/planId/1304121/tab/TEAM">Yale FES</a>
                </p>

                <p class="contest-proposal-description">Team members: Rebeka Ryvola, Bo Uuganbayar, Rocio Sanz, Angel Hsu, and Vrinda Manglik. Meet CliO! A virtual green
                    pet who responds with your low-carbon lifestyle choices.</p>
            </div>
        </div>
        <!-- Contest Accordion 11 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Transportation Efficiency</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/7/planId/1304137">Smart Mobility for the 21st Century</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/7/planId/1304137/tab/TEAM">Galen Wilkerson</a>
                </p>

                <p class="contest-proposal-description">A bottom-up mobility-centered approach, to simply get individuals from A to B by intelligently using available
                    data and mobile devices.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <hr class="blue-line" />
                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/7/planId/1304136">Open CarPool - Open Source for Efficient Commute </a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/7/planId/1304136/tab/TEAM">eBay Green Team - Clemens Rath</a>
                </p>

                <p class="contest-proposal-description">A simple open source framework for carpools within companies reduces traffic in daily commute and fosters ridesharing
                    acceptance.</p>
            </div>
        </div>
        <!-- Contest Accordion 12 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Waste Management</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/26/planId/1304162">Mission 2030 - Zero Construction Renovation Demolition Waste to Landfill by 2030</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/26/planId/1304162/tab/TEAM">CRI Council - Renee Gratton</a>
                </p>

                <p class="contest-proposal-description">This call-to-action is a change management initiative, to change how the building industry views and deals with
                    waste and other resources.</p>
            </div>
        </div>
        <!-- PARTNER CONTERSTS -->

        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/ZdFe2g0.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Partner Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Hydraulic Fracturing (Fracking)</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.ucsusa.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/1j3RuMf.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/30/planId/1304101">Dual purpose fracking</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/30/planId/1304101/tab/TEAM">John Dowse</a>
                </p>

                <p class="contest-proposal-description">Increased fracking will create sites for CO2 sequestration. The gas/oil piping will be suitable for CO2 once
                    the well is largely exhausted.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/30/planId/1304103">Methane-sniffing drones with distributed mobile sensors!</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/30/planId/1304103/tab/TEAM">Mark Capron and Clifford Goudey </a>
                </p>

                <p class="contest-proposal-description">States require drillers to &quot;buy&quot; wasted fuels from gas utilities. The utilities deploy methane-sniffing
                    drones and mobile sensors.</p>
            </div>
        </div>
        <!-- Contest Accordion 2 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Local Solutions</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://www.transitionus.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/B1PycXK.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Judges&#39; &amp; Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/13/planId/1304105">Transition Lab: Scalable Resilience Education and Models for New Local Economies</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/13/planId/1304105/tab/TEAM">Transition Lab - Russell Evans and Jake Hanson</a>
                </p>

                <p class="contest-proposal-description">A replicable grassroots education teaching the skills and mindset for local resilience, powered by new and viable
                    economic models.</p>
            </div>
        </div>
        <!-- Contest Accordion 3 -->

        <div class="accordion-element">
            <img class="accordion-icon" src="https://i.imgur.com/JMi6GOJ.png" />
            <span class="upper contest-title">Urban Adaptation: Climate Resilient Cities</span>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <p class="upper">This contest was run in cooperation with</p>
                    <a href="http://icleiusa.org/">
                        <img class="sponsor-logo" src="https://i.imgur.com/j8yODzJ.jpg" style="display: none !important;" />
                    </a>
                </div>
            </div>

            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="contest-title-under upper">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/14/planId/1304107">Integral GIS - A conceptual framework for participatory adaptation planning</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/14/planId/1304107/tab/TEAM">Lynn Rosentrater</a>
                </p>

                <p class="contest-proposal-description">A planning approach that uses common tools in innovative ways to communicate about climate change and facilitate
                    adaptation decision-making.</p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="contest-title-under upper">Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/14/planId/1304110">Seasonal Migration Routes Identification System and Workshops: A New Strategy</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/14/planId/1304110/tab/TEAM">Michael Houle</a>
                </p>

                <p class="contest-proposal-description">Prepare Vietnamese cities&#39; housing infrastructures for potential seasonal migrants influx from Ca Mau and
                    Kien Giang provinces, Vietnam.</p>
            </div>
        </div>
    </div>
    <!-- ****************** 2011 ****************** -->

    <div class="2011 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://i.imgur.com/vVFVYcy.png" />
            <img class="winner-icon" src="https://i.imgur.com/bwTzJ5n.png" />
            <h1 class="upper image-title">Contest Winners</h1>

            <p class="image-title-sub">&amp; Awardees</p>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">2</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">6</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <br />
        <!-- Contest Accordion 1 -->
        <div class="accordion-element" style="cursor: initial;">
            <span class="upper contest-title" style="padding: 10px 41px; display: inline-block;">Global Category</span>

            <hr class="blue-line" />
            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> 1st Place, Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/4/planId/15203">2010 Winners Combined</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/4/planId/15203/tab/TEAM">Dennis Peterson</a>
                </p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under">2nd Place, Popular Choice and Judges&#39; Special Commendation</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/4/planId/15201">The Planet or Your Plate: Mitigate Climate Change by Going Meatless </a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/4/planId/15201/tab/TEAM">beach-babe-in-fl</a>
                </p>

                <p class="contest-proposal-description">An environmental activist and founder of the Daily Kos Meatless Advocates, Nancy A. Heitzeg, of St. Catherine
                    University, and Gerard Wedderburn Bisshop, advisor and senior scientist at the World Preservation Foundation.</p>
            </div>
        </div>
        <br />
        <!-- Contest Accordion 2 -->
        <div class="accordion-element" style="cursor: initial;">
            <span class="upper contest-title" style="padding: 10px 41px; display: inline-block;">National Category</span>

            <hr class="blue-line" />
            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under">1st Place, Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15204">Cycling Carbon</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15204/tab/TEAM">Dennis Peterson</a>
                </p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner" src="https://i.imgur.com/Ryo7n1o.png" />
                    <span class="upper contest-title-under"> 2nd Place, Popular Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15205">Dream for a Green Future</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15205/tab/TEAM">Arnab Mandal and Pooja Aroora</a>
                </p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15207">Personal Rapid Transit Grids</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15207/tab/TEAM">Christopher Fry</a>
                </p>
            </div>

            <hr class="blue-line" />
            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <img class="accordion-icon-inner accordion-icon-inner-special" src="https://i.imgur.com/rEumxa7.png" />
                    <span class="upper contest-title-under">Judges&#39; Choice Winner</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15207">Climate Proofing the Economics of Socially Sustainable Small-Scale Agricultural Systems</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/5/planId/15207/tab/TEAM">Maruf Sanni, Idowu Ologeh and William O. Siyanbola</a>
                </p>
            </div>
        </div>
    </div>
    <!-- ****************** 2010 ****************** -->

    <div class="2010 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://i.imgur.com/vVFVYcy.png" />
            <img class="winner-icon" src="https://i.imgur.com/RGZKxdB.png" />
            <h1 class="upper image-title">Contest Winners</h1>

            <p class="image-title-sub">&amp; Awardees</p>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">1</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">4</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <br />
        <!-- GLOBAL CONTEST -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/4CAFFOo.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Global Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>
        <!-- Contest Accordion 1 -->

        <div class="accordion-element" style="cursor: initial;">
            <img class="accordion-icon" src="https://i.imgur.com/Ryo7n1o.png" />
            <span class="upper contest-title">Popular Choice Award</span>

            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <span class="upper contest-title-under">1st place</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/2/planId/15522">Overcoming the North-South Divide</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/2/planId/15522/tab/TEAM">Christophe Chung and Shoko Takemoto</a>
                </p>
            </div>

            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <span class="upper contest-title-under">2nd place</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/2/planId/15523">Carbon Rights</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/2/planId/15523/tab/TEAM">Dennis Peterson</a>
                </p>
            </div>
        </div>
        <br />
        <!-- Contest Accordion 2 -->
        <div class="accordion-element" style="cursor: initial;">
            <img class="accordion-icon" src="https://i.imgur.com/rEumxa7.png" />
            <span class="upper contest-title">Judges&#39; Choice Award</span>

            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <span class="upper contest-title-under">1st place (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/2/planId/15525">Realistic Climate Proposal</a>
                    <span> by </span>
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/2/planId/15525/tab/TEAM">Timothy Cronin, Arthur Gueneau, Jennifer Morris, and Paul Kishimoto</a>
                </p>
            </div>

            <div class="accordion-inner-no">
                <div class="accordion-inner-header">
                    <span class="upper contest-title-under">1st place (tie)</span>
                </div>

                <p class="contest-proposal">
                    <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/2/planId/15522">Overcoming the North-South Divide</a>
                </p>
            </div>
        </div>
    </div>
    <!-- ****************** 2009 ****************** -->

    <div class="2009 content">
        <div class="relative">
            <img class="winner-picture darken" src="https://i.imgur.com/vVFVYcy.png" />
            <img class="winner-icon" src="https://i.imgur.com/Hd3zpQc.png" />
            <h1 class="upper image-title">Contest Winners</h1>

            <p class="image-title-sub">&amp; Awardees</p>
            <span class="upper indigogo-button">
                <a href="https://www.indiegogo.com/partners/ClimateColab" style="color: white; text-decoration: none;">Support them on Indiegogo</a>
            </span>
        </div>
        <!-- Bubble Statistics-->

        <div style="text-align: center;">
            <div class="stat-bubble-outer">
                <p class="stat-bubble-number">1</p>

                <p class="stat-bubble-title upper">Contests</p>
            </div>

            <div class="stat-bubble-outer" style="margin-right:0;">
                <p class="stat-bubble-number">4</p>

                <p class="stat-bubble-title upper">Winners</p>
            </div>
        </div>
        <br />
        <br />
        <br />
        <!-- GLOBAL CONTEST -->
        <table class="contest-kind-header">
            <tbody>
            <tr>
                <td class="contest-table-icon">
                    <img class="icons" src="https://i.imgur.com/4CAFFOo.png" />
                </td>
                <td>
                    <h1 class="upper icon-title">Global Contests</h1>
                </td>
            </tr>
            </tbody>
        </table>

        <div class="accordion-inner-no">
            <div class="accordion-inner-header">
                <span class="upper contest-title-under">1st place</span>
            </div>

            <p class="contest-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1/planId/4906">350 ppm or bust</a>
                <span> by </span>
                <a href="http://www.jasonjay.com/M">Jason Jay</a>
            </p>
        </div>
        &nbsp;

        <div class="accordion-inner-no">
            <div class="accordion-inner-header">
                <span class="upper contest-title-under">2nd place</span>
            </div>

            <p class="contest-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1/planId/3302">IEA 450 ppm scenario</a>
                <span> by </span>
                <a href="http://www.iea.org/">International Energy Agency</a>
            </p>
        </div>
        &nbsp;

        <div class="accordion-inner-no">
            <div class="accordion-inner-header">
                <span class="upper contest-title-under">3rd place</span>
            </div>

            <p class="contest-proposal">
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1/planId/3312">Drew Jones TEDx proposal</a>
                <span> by </span>
                <a href="https://www.climatecolab.org/web/guest/plans/-/plans/contestId/1/planId/3301">Drew Jones, Climate Interactive and Business as Usual</a>
            </p>
        </div>
    </div>

<p>
    <img id="scroller" onclick="toTheTop(this)" src="https://i.imgur.com/mLY1vdp.png" />
    <!--   https://i.imgur.com/MOxDo4v.png-->
    <!-- ****************** END OF WRAPPER ****************** -->
    <!-- ****************** JAVASCRIPT ****************** -->
    <script type="text/javascript">
        var touchEvent = ''ontouchstart'' in window ? ''touchstart'' : ''click'';

        $(document).ready(function (id) {

            $(''.content'').hide(); // hide all years at the beginning  //
            $(''.2017'').show(); // just show the latest year at the beginning // ** UPDATE THIS **
            $(''.accordion-inner'').hide();
            $(''.image-title'').show();
            $(''a'').attr(''target'', ''_blank'');
            $(''#2017'').css("background-color", "#0088f1"); // sets the background of the navigation of the current year to a darker blue // ** UPDATE THIS **
            $(''#content'').css("padding-top", "0px");
            $(''.wrapper'').css(''visibility'', ''visible'');

            $(document).on(touchEvent, ''.year'', function (id) { // function that shows the content of the clicked year and hides the other years'' content //
                $(''.content'').hide();
                $(''.year'').css("background-color", "#30a3fb");
                $("." + this.id).fadeIn();
                $(this).css("background-color", "#0088f1");
            });

            $(window).scroll(function () { // scroller fadeIn
                if ($(this).scrollTop() > 1000 && $(this).scrollTop() < ($(document).height() - 1250)) {
                    $(''#scroller'').stop(true, true).fadeIn();
                } else {
                    $(''#scroller'').stop(true, true).fadeOut();
                }
            });

        });

        $(".accordion-inner").on("click", function (event) {
            event.stopPropagation();
        });

        $(".accordion-element").on("click", function (event) {
            if ($(this).children(''img'').attr("src") == "https://i.imgur.com/JMi6GOJ.png") {
                $(this).children(''img'').attr("src", "https://i.imgur.com/xAVbDZx.png");
            } else {
                $(this).children(''img'').attr("src", "https://i.imgur.com/JMi6GOJ.png");
            }
            $(this).children(''.accordion-inner'').slideToggle();
        });

        function expandAll(elem) { // function that changes the text of the "expand all" button when clicked //
            if ($(elem).html() == ''expand all'') {
                $(elem).html(''hide all'');
                $(''.accordion-inner'').slideDown();
                $(''.accordion-element'').children(''img'').attr("src", "https://i.imgur.com/xAVbDZx.png");
            } else {
                $(elem).html(''expand all'');
                $(''.accordion-inner'').slideUp();
                $(''.accordion-element'').children(''img'').attr("src", "https://i.imgur.com/JMi6GOJ.png")
            }
        }

        function toTheTop(elem) { // scroller Scroll
            $(''html, body'').animate({
                scrollTop: $($(''.list'')).offset().top
            }, 500);
            return false;
        }
    </script>
</p>
</div>
',
 'en')

/* add new version to contentArticle */

UPDATE `xcolab_ContentArticle` t
SET t.`maxVersionId` = SCOPE_IDENTITY()
WHERE t.`contentArticleId` = 1214
