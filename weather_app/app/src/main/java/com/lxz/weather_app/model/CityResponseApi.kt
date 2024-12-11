package com.lxz.weather_app.model


import com.google.gson.annotations.SerializedName

class CityResponseApi : ArrayList<CityResponseApi.CityResponseApiItem>(){
    data class CityResponseApiItem(
        @SerializedName("country")
        val country: String?, // GB
        @SerializedName("lat")
        val lat: Double?, // 51.5073219
        @SerializedName("local_names")
        val localNames: LocalNames?,
        @SerializedName("lon")
        val lon: Double?, // -0.1276474
        @SerializedName("name")
        val name: String?, // London
        @SerializedName("state")
        val state: String? // England
    ) {
        data class LocalNames(
            @SerializedName("ab")
            val ab: String?, // Лондон
            @SerializedName("af")
            val af: String?, // Londen
            @SerializedName("am")
            val am: String?, // ለንደን
            @SerializedName("an")
            val an: String?, // Londres
            @SerializedName("ar")
            val ar: String?, // لندن
            @SerializedName("ascii")
            val ascii: String?, // London
            @SerializedName("av")
            val av: String?, // Лондон
            @SerializedName("ay")
            val ay: String?, // London
            @SerializedName("az")
            val az: String?, // London
            @SerializedName("ba")
            val ba: String?, // Лондон
            @SerializedName("be")
            val be: String?, // Лондан
            @SerializedName("bg")
            val bg: String?, // Лондон
            @SerializedName("bh")
            val bh: String?, // लंदन
            @SerializedName("bi")
            val bi: String?, // London
            @SerializedName("bm")
            val bm: String?, // London
            @SerializedName("bn")
            val bn: String?, // লন্ডন
            @SerializedName("bo")
            val bo: String?, // ལོན་ཊོན།
            @SerializedName("br")
            val br: String?, // Londrez
            @SerializedName("bs")
            val bs: String?, // London
            @SerializedName("ca")
            val ca: String?, // Londres
            @SerializedName("ce")
            val ce: String?, // Лондон
            @SerializedName("co")
            val co: String?, // Londra
            @SerializedName("cr")
            val cr: String?, // ᓬᐊᐣᑕᐣ
            @SerializedName("cs")
            val cs: String?, // Londýn
            @SerializedName("cu")
            val cu: String?, // Лондонъ
            @SerializedName("cv")
            val cv: String?, // Лондон
            @SerializedName("cy")
            val cy: String?, // Llundain
            @SerializedName("da")
            val da: String?, // London
            @SerializedName("de")
            val de: String?, // London
            @SerializedName("ee")
            val ee: String?, // London
            @SerializedName("el")
            val el: String?, // Λονδίνο
            @SerializedName("en")
            val en: String?, // London
            @SerializedName("eo")
            val eo: String?, // Londono
            @SerializedName("es")
            val es: String?, // Londres
            @SerializedName("et")
            val et: String?, // London
            @SerializedName("eu")
            val eu: String?, // Londres
            @SerializedName("fa")
            val fa: String?, // لندن
            @SerializedName("feature_name")
            val featureName: String?, // London
            @SerializedName("ff")
            val ff: String?, // London
            @SerializedName("fi")
            val fi: String?, // Lontoo
            @SerializedName("fj")
            val fj: String?, // Lodoni
            @SerializedName("fo")
            val fo: String?, // London
            @SerializedName("fr")
            val fr: String?, // Londres
            @SerializedName("fy")
            val fy: String?, // Londen
            @SerializedName("ga")
            val ga: String?, // Londain
            @SerializedName("gd")
            val gd: String?, // Lunnainn
            @SerializedName("gl")
            val gl: String?, // Londres
            @SerializedName("gn")
            val gn: String?, // Lóndyre
            @SerializedName("gu")
            val gu: String?, // લંડન
            @SerializedName("gv")
            val gv: String?, // Lunnin
            @SerializedName("ha")
            val ha: String?, // Landan
            @SerializedName("he")
            val he: String?, // לונדון
            @SerializedName("hi")
            val hi: String?, // लंदन
            @SerializedName("hr")
            val hr: String?, // London
            @SerializedName("ht")
            val ht: String?, // Lonn
            @SerializedName("hu")
            val hu: String?, // London
            @SerializedName("hy")
            val hy: String?, // Լոնդոն
            @SerializedName("ia")
            val ia: String?, // London
            @SerializedName("id")
            val id: String?, // London
            @SerializedName("ie")
            val ie: String?, // London
            @SerializedName("ig")
            val ig: String?, // London
            @SerializedName("io")
            val io: String?, // London
            @SerializedName("is")
            val isX: String?, // London
            @SerializedName("it")
            val `it`: String?, // Londra
            @SerializedName("iu")
            val iu: String?, // ᓚᓐᑕᓐ
            @SerializedName("ja")
            val ja: String?, // ロンドン
            @SerializedName("jv")
            val jv: String?, // London
            @SerializedName("ka")
            val ka: String?, // ლონდონი
            @SerializedName("kk")
            val kk: String?, // Лондон
            @SerializedName("kl")
            val kl: String?, // London
            @SerializedName("km")
            val km: String?, // ឡុងដ៍
            @SerializedName("kn")
            val kn: String?, // ಲಂಡನ್
            @SerializedName("ko")
            val ko: String?, // 런던
            @SerializedName("ku")
            val ku: String?, // London
            @SerializedName("kv")
            val kv: String?, // Лондон
            @SerializedName("kw")
            val kw: String?, // Loundres
            @SerializedName("ky")
            val ky: String?, // Лондон
            @SerializedName("lb")
            val lb: String?, // London
            @SerializedName("li")
            val li: String?, // Londe
            @SerializedName("ln")
            val ln: String?, // Lóndɛlɛ
            @SerializedName("lo")
            val lo: String?, // ລອນດອນ
            @SerializedName("lt")
            val lt: String?, // Londonas
            @SerializedName("lv")
            val lv: String?, // Londona
            @SerializedName("mg")
            val mg: String?, // Lôndôna
            @SerializedName("mi")
            val mi: String?, // Rānana
            @SerializedName("mk")
            val mk: String?, // Лондон
            @SerializedName("ml")
            val ml: String?, // ലണ്ടൻ
            @SerializedName("mn")
            val mn: String?, // Лондон
            @SerializedName("mr")
            val mr: String?, // लंडन
            @SerializedName("ms")
            val ms: String?, // London
            @SerializedName("mt")
            val mt: String?, // Londra
            @SerializedName("my")
            val my: String?, // လန်ဒန်မြို့
            @SerializedName("na")
            val na: String?, // London
            @SerializedName("ne")
            val ne: String?, // लन्डन
            @SerializedName("nl")
            val nl: String?, // Londen
            @SerializedName("nn")
            val nn: String?, // London
            @SerializedName("no")
            val no: String?, // London
            @SerializedName("nv")
            val nv: String?, // Tooh Dineʼé Bikin Haalʼá
            @SerializedName("ny")
            val ny: String?, // London
            @SerializedName("oc")
            val oc: String?, // Londres
            @SerializedName("oj")
            val oj: String?, // Baketigweyaang
            @SerializedName("om")
            val om: String?, // Landan
            @SerializedName("or")
            val or: String?, // ଲଣ୍ଡନ
            @SerializedName("os")
            val os: String?, // Лондон
            @SerializedName("pa")
            val pa: String?, // ਲੰਡਨ
            @SerializedName("pl")
            val pl: String?, // Londyn
            @SerializedName("ps")
            val ps: String?, // لندن
            @SerializedName("pt")
            val pt: String?, // Londres
            @SerializedName("qu")
            val qu: String?, // London
            @SerializedName("rm")
            val rm: String?, // Londra
            @SerializedName("ro")
            val ro: String?, // Londra
            @SerializedName("ru")
            val ru: String?, // Лондон
            @SerializedName("sa")
            val sa: String?, // लन्डन्
            @SerializedName("sc")
            val sc: String?, // Londra
            @SerializedName("sd")
            val sd: String?, // لنڊن
            @SerializedName("se")
            val se: String?, // London
            @SerializedName("sh")
            val sh: String?, // London
            @SerializedName("si")
            val si: String?, // ලන්ඩන්
            @SerializedName("sk")
            val sk: String?, // Londýn
            @SerializedName("sl")
            val sl: String?, // London
            @SerializedName("sm")
            val sm: String?, // Lonetona
            @SerializedName("sn")
            val sn: String?, // London
            @SerializedName("so")
            val so: String?, // London
            @SerializedName("sq")
            val sq: String?, // Londra
            @SerializedName("sr")
            val sr: String?, // Лондон
            @SerializedName("st")
            val st: String?, // London
            @SerializedName("su")
            val su: String?, // London
            @SerializedName("sv")
            val sv: String?, // London
            @SerializedName("sw")
            val sw: String?, // London
            @SerializedName("ta")
            val ta: String?, // இலண்டன்
            @SerializedName("te")
            val te: String?, // లండన్
            @SerializedName("tg")
            val tg: String?, // Лондон
            @SerializedName("th")
            val th: String?, // ลอนดอน
            @SerializedName("tk")
            val tk: String?, // London
            @SerializedName("tl")
            val tl: String?, // Londres
            @SerializedName("to")
            val to: String?, // Lonitoni
            @SerializedName("tr")
            val tr: String?, // Londra
            @SerializedName("tt")
            val tt: String?, // Лондон
            @SerializedName("ug")
            val ug: String?, // لوندۇن
            @SerializedName("uk")
            val uk: String?, // Лондон
            @SerializedName("ur")
            val ur: String?, // علاقہ لندن
            @SerializedName("uz")
            val uz: String?, // London
            @SerializedName("vi")
            val vi: String?, // Luân Đôn
            @SerializedName("vo")
            val vo: String?, // London
            @SerializedName("wa")
            val wa: String?, // Londe
            @SerializedName("wo")
            val wo: String?, // Londar
            @SerializedName("yi")
            val yi: String?, // לאנדאן
            @SerializedName("yo")
            val yo: String?, // Lọndọnu
            @SerializedName("zh")
            val zh: String?, // 伦敦
            @SerializedName("zu")
            val zu: String? // ILondon
        )
    }
}