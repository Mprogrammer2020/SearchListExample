package com.netsetdemoproject.utils

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.netsetdemoproject.ui.base.BaseView

@StateStrategyType(AddToEndSingleStrategy::class)
interface CommonInterface:BaseView {

    interface SearchView :BaseView{
        fun ResponseSucess(message: Void?)
    }

}