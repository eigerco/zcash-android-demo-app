# Android demo app for Zcash

This is an app built for demonstration of the features of a UniFFI library translating the librustzcash library built by the ECC.

Some ground rules:
- it was not built to be used as a wallet. It doesn't contain a lot of basic instruments like error handling
- it is meant for developers to be ran
- it is meant to be used for debugging or as starting point for building a wallet-like application
- the code is very simplistic and doesn't reflect the complexity of the UX of a modern Android app, 
- but we still tried to use the most modern version of the UI (Android Compose).

Some pieces were taken from the [already existing SDK by the ECC](https://github.com/zcash/zcash-android-wallet-sdk), especially the protobuf for using lightwalletd.

In order to use it, it's best to have Android Studio installed. Before you start using the features connected to the database, it's best to set a seed in `Constants`.


There are several pages available:

 - the Main activity, the one showing when the app is started, has three voices:
   - Reset database: it dumps and reinitialize the database and tables. It also creates the account which will be used for the spending operation.
   - Download blocks: it retrieves the last 60 blocks (as default, it may be set in `Constants`). It is useful when we want to use the spending feature.
   - Go to menu: it shows more features.
 - the Menu activity has four "go-to" voices, which are:
   - Spend a note: it shows a screen where there are three actions to perform:
     - you can input an amount in ZATs
     - you can create a transaction
     - you can then submit it to the chain
   - Explore transaction: you can see the details of a transparent transaction,  or for a shielded transaction for which there is the viewing key in the database.
   - Decode Unified Address: paste a unified address and see the addresses it is composed of
   - Get transparent balance: paste a transparent address and get its total balance.

BEFORE being able to spend anything, you need to have the notes saved in the internal database. 
So, in general, for spending, this is how an ideal scenario goes:
 - Write down the seed chosen for the wallet in `Constants`. It's an array of unsigned bytes. An ideal length would be 32.
 - After creating the wallet, you may get the transparent and shielded address so created. The shielded address belongs to the sapling pool.
 - Get TAZs to the **shielded** address [here](https://faucet.zecpages.com/) (or some other faucet for testnet).
 - After you see that the transaction was mined and got at least one confirmation (or how many were set in `Constants`),
 - Tap on "Download blocks". You should see that the note was downloaded because it will be visible under spendable notes in the main page, or if you paste the transaction hash in "Explore the transaction".
 - You should be all set to go to "Spend a note", and follow from there.

The default of the app is to use the testnet but that can be changed in `Constants`, together with all other defaults and settings.