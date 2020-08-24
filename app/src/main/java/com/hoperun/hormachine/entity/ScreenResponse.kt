package com.hoperun.hormachine.entity

import java.io.Serializable

class ScreenResponse : Serializable {

     val Code = ""

     val Message = ""

     val Result: ScreenInfo? = null

    class ScreenInfo{
        var XZ = false
        var ID = ""  //"AFC4D5089B9E4AF48AB3A86EED5E5586"
        var LCDM = ""  //"F2"
        var LCMC = "" //"横机二楼(保全)"
        var CJMC = "" //"横机车间"
        var GDWZ = 0.5
        var ZDR = ""  //"chenxing"
        var ZDSJ = ""  //"2020-06-04 17:43:27"

        //var  ZDSJ_To:null
        var XGR = ""  //"chenxing"
        var XGSJ = "" //"2020-06-04 17:43:27"
        var ZT = ""
        var SFSC = ""
        var ZTS = 0
        var KTS = 0
        var KTL = 0.0
        var LeftList: List<ScreenItem> = mutableListOf()
        var RightList: List<ScreenItem> = mutableListOf()

        //以下暂时不用
        var ZCList: List<ScreenItem> = mutableListOf()
        var HJZList: List<ScreenItem> = mutableListOf()
        var BQZList: List<ScreenItem> = mutableListOf()
        var BQWCList: List<ScreenItem> = mutableListOf()
        var TTList: List<ScreenItem> = mutableListOf()
    }



}