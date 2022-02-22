package com.example.bf_kotlin_client.viewmodels

class MainActivityViewModel {

    init {

    }

//test code
/*private val appAuthApiWorker = AppAuthApiWorker()
    private val productCategoryApiWorker = ProductCategoryApiWorker()

    val fieldApiKey: ObservableField<String> = ObservableField("data....")
    val fieldApiKey2: ObservableField<String> = ObservableField("api key")
    val fieldProductsCategories: ObservableField<String> = ObservableField("data....")

    private fun updateFieldApiKey(data: String) {
        val appAuthResponse = Gson().fromJson(data, AppAuthResponse::class.java)
        GlobalVariables.instance.apiKey = appAuthResponse.apiKey

        fieldApiKey.set(appAuthResponse.apiKey)
    }

    private fun updateFieldCategories(data: String) {
        val response = Gson().fromJson(data, ProductsCategoriesResponse::class.java)
        fieldProductsCategories.set(response.productCategories[0].name)
    }

    fun authorize() {
        appAuthApiWorker.auth(::updateFieldApiKey)

    }

    fun getAllCategories() {
        productCategoryApiWorker.getAll(::updateFieldCategories)
    }

    fun saveApiKeyToLocalDb() {
        GlobalScope.launch(Dispatchers.IO) {
            GlobalVariables.instance.appDatabase.keyValuePairsRepository.insert(
                KeyValuePair(
                    "api_key",
                    GlobalVariables.instance.apiKey
                )
            )
        }
    }

    fun loadApiKeyFromLocalDb() {
        GlobalScope.launch(Dispatchers.IO) {
            var value =
                GlobalVariables.instance.appDatabase.keyValuePairsRepository.getByKey("api_key")

            if (value == null) {
                fieldApiKey2.set("api key not found")
            } else {
                fieldApiKey2.set(value)
            }
        }
    }*/

}