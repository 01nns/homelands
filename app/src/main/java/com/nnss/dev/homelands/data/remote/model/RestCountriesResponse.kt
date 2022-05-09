package com.nnss.dev.homelands.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class RestCountriesResponse : Parcelable {
    @SerializedName("name")
    @Expose
    val name: Name? = null

    @SerializedName("tld")
    @Expose
    val tld: List<String>? = null

    @SerializedName("cca2")
    @Expose
    val cca2: String? = null

    @SerializedName("ccn3")
    @Expose
    val ccn3: String? = null

    @SerializedName("cca3")
    @Expose
    val cca3: String? = null

    @SerializedName("cioc")
    @Expose
    val cioc: String? = null

    @SerializedName("independent")
    @Expose
    val independent: Boolean? = null

    @SerializedName("status")
    @Expose
    val status: String? = null

    @SerializedName("unMember")
    @Expose
    val unMember: Boolean? = null

    @SerializedName("currencies")
    @Expose
    val currencies: Currencies? = null

    @SerializedName("idd")
    @Expose
    val idd: Idd? = null

    @SerializedName("capital")
    @Expose
    val capital: List<String>? = null

    @SerializedName("altSpellings")
    @Expose
    val altSpellings: List<String>? = null

    @SerializedName("region")
    @Expose
    val region: String? = null

    @SerializedName("subregion")
    @Expose
    val subregion: String? = null

    @SerializedName("languages")
    @Expose
    val languages: Languages? = null

    @SerializedName("translations")
    @Expose
    val translations: Translations? = null

    @SerializedName("latlng")
    @Expose
    val latlng: List<Double>? = null

    @SerializedName("landlocked")
    @Expose
    val landlocked: Boolean? = null

    @SerializedName("borders")
    @Expose
    val borders: List<String>? = null

    @SerializedName("area")
    @Expose
    val area: Double? = null

    @SerializedName("demonyms")
    @Expose
    val demonyms: Demonyms? = null

    @SerializedName("flag")
    @Expose
    val flag: String? = null

    @SerializedName("maps")
    @Expose
    val maps: Maps? = null

    @SerializedName("population")
    @Expose
    val population: Int? = null

    @SerializedName("gini")
    @Expose
    val gini: Gini? = null

    @SerializedName("fifa")
    @Expose
    val fifa: String? = null

    @SerializedName("car")
    @Expose
    val car: Car? = null

    @SerializedName("timezones")
    @Expose
    val timezones: List<String>? = null

    @SerializedName("continents")
    @Expose
    val continents: List<String>? = null

    @SerializedName("flags")
    @Expose
    val flags: Flags? = null

    @SerializedName("coatOfArms")
    @Expose
    val coatOfArms: CoatOfArms? = null

    @SerializedName("startOfWeek")
    @Expose
    val startOfWeek: String? = null

    @SerializedName("capitalInfo")
    @Expose
    val capitalInfo: CapitalInfo? = null

    @SerializedName("postalCode")
    @Expose
    val postalCode: PostalCode? = null
}

class Ara {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class CapitalInfo {
    @SerializedName("latlng")
    @Expose
    val latlng: List<Double>? = null
}

class Car {
    @SerializedName("signs")
    @Expose
    val signs: List<String>? = null

    @SerializedName("side")
    @Expose
    val side: String? = null
}

class Ces {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class CoatOfArms {
    @SerializedName("png")
    @Expose
    val png: String? = null

    @SerializedName("svg")
    @Expose
    val svg: String? = null
}

class Currencies {
    @SerializedName("UYU")
    @Expose
    val uyu: Uyu? = null
}

class Cym {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Demonyms {
    @SerializedName("eng")
    @Expose
    val eng: Eng? = null

    @SerializedName("fra")
    @Expose
    val fra: Fra_1? = null
}

class Deu {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Eng {
    @SerializedName("f")
    @Expose
    val f: String? = null

    @SerializedName("m")
    @Expose
    val m: String? = null
}

class Est {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Fin {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Flags {
    @SerializedName("png")
    @Expose
    val png: String? = null

    @SerializedName("svg")
    @Expose
    val svg: String? = null
}

class Fra {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Fra_1 {
    @SerializedName("f")
    @Expose
    val f: String? = null

    @SerializedName("m")
    @Expose
    val m: String? = null
}

class Gini {
    @SerializedName("2019")
    @Expose
    val _2019: Double? = null
}

class Hrv {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Hun {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Idd {
    @SerializedName("root")
    @Expose
    val root: String? = null

    @SerializedName("suffixes")
    @Expose
    val suffixes: List<String>? = null
}

class Ita {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Jpn {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Kor {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Languages {
    @SerializedName("spa")
    @Expose
    val spa: String? = null
}

class Maps {
    @SerializedName("googleMaps")
    @Expose
    val googleMaps: String? = null

    @SerializedName("openStreetMaps")
    @Expose
    val openStreetMaps: String? = null
}

class Name {
    @SerializedName("common")
    @Expose
    val common: String? = null

    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("nativeName")
    @Expose
    val nativeName: NativeName? = null
}

class NativeName {
    @SerializedName("spa")
    @Expose
    val spa: Spa? = null
}

class Nld {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Per {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Pol {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Por {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class PostalCode {
    @SerializedName("format")
    @Expose
    val format: String? = null

    @SerializedName("regex")
    @Expose
    val regex: String? = null
}

class Rus {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Slk {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Spa {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Spa_1 {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Swe {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Translations {
    @SerializedName("ara")
    @Expose
    val ara: Ara? = null

    @SerializedName("ces")
    @Expose
    val ces: Ces? = null

    @SerializedName("cym")
    @Expose
    val cym: Cym? = null

    @SerializedName("deu")
    @Expose
    val deu: Deu? = null

    @SerializedName("est")
    @Expose
    val est: Est? = null

    @SerializedName("fin")
    @Expose
    val fin: Fin? = null

    @SerializedName("fra")
    @Expose
    val fra: Fra? = null

    @SerializedName("hrv")
    @Expose
    val hrv: Hrv? = null

    @SerializedName("hun")
    @Expose
    val hun: Hun? = null

    @SerializedName("ita")
    @Expose
    val ita: Ita? = null

    @SerializedName("jpn")
    @Expose
    val jpn: Jpn? = null

    @SerializedName("kor")
    @Expose
    val kor: Kor? = null

    @SerializedName("nld")
    @Expose
    val nld: Nld? = null

    @SerializedName("per")
    @Expose
    val per: Per? = null

    @SerializedName("pol")
    @Expose
    val pol: Pol? = null

    @SerializedName("por")
    @Expose
    val por: Por? = null

    @SerializedName("rus")
    @Expose
    val rus: Rus? = null

    @SerializedName("slk")
    @Expose
    val slk: Slk? = null

    @SerializedName("spa")
    @Expose
    val spa: Spa_1? = null

    @SerializedName("swe")
    @Expose
    val swe: Swe? = null

    @SerializedName("urd")
    @Expose
    val urd: Urd? = null

    @SerializedName("zho")
    @Expose
    val zho: Zho? = null
}

class Urd {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}

class Uyu {
    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("symbol")
    @Expose
    val symbol: String? = null
}

class Zho {
    @SerializedName("official")
    @Expose
    val official: String? = null

    @SerializedName("common")
    @Expose
    val common: String? = null
}