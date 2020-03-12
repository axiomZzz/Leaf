package com.github.axiomzzz.leaf

data class ItemAddList (val name: String=" " , val img:String=" ",val weight:Int=1){
}

fun ItemAddList.toMapCustom():Map<String,Any>{

    val result=HashMap<String,Any>()

    result["name"] = name
    result["weight"]=weight

    return result
}