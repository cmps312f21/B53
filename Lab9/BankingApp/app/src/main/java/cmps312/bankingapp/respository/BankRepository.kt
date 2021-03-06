package cmps312.bankingapp.respository

import android.content.Context
import cmps312.bankingapp.model.Account
import cmps312.bankingapp.model.Beneficiary
import cmps312.bankingapp.model.Transfer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class BankRepository(private val context: Context) {
    private fun readData(filename: String) =
        context.assets.open(filename).bufferedReader().use { it.readText() }

    @ExperimentalSerializationApi
    fun getTransfers() =
        Json.decodeFromString<List<Transfer>>(readData("transfers.json"))

    @ExperimentalSerializationApi
    fun getBeneficiaries() =
        Json.decodeFromString<List<Beneficiary>>(readData("beneficiaries.json"))

    @ExperimentalSerializationApi
    fun getAccounts() =
        Json.decodeFromString<List<Account>>(readData("accounts.json"))

    @ExperimentalSerializationApi
    fun getAccount(accountNo: String) = getAccounts().find { it.accountNo == accountNo }
}