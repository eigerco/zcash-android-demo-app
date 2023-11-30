# Android demo app for Zcash

## Introduction

This is an app built for demonstration of the features of a UniFFI library translating the librustzcash library built by the ECC.

### Some ground rules/suggestions/recommendations:

- it was not created to be used as a wallet. It doesn't contain a lot of basic instruments like error handling and like features
- it is meant to be ran by developers
- it is meant to be used for debugging or as starting point for building a wallet-like application
- the code is very simplistic and doesn't reflect the complexity of the UX of a modern Android app, 
- but we still tried to use the most modern version of the UI (Android Compose) and idiomatic Kotlin code.

### This said, for a successful usage

- It's best to have Android Studio installed.
- The first time the app will be loaded into the editor, it will take some 10-20 minutes to download and cache relevant dependencies.
- Before you start using the features connected to the database, it's necessary to set a seed (`SEED`) and the wallet birthday (`WALLET_BIRTHDAY_HEIGHT`) in `Constants`. 
- The device needs to have [sapling-spend.params](https://download.z.cash/downloads/sapling-spend.params) and [sapling-output.params](https://download.z.cash/downloads/sapling-output.params) stored under `z.cash.demoapp/files`.
- If you prefer to have the params files somewhere else, you may easily change that in the code.
- Most steps are notified as successful or failing by toast notifications, and when needed (for example, to copy a hash from the emulator) logs too.

Some pieces were taken from the [already existing SDK by the ECC](https://github.com/zcash/zcash-android-wallet-sdk), especially the protobuf for using lightwalletd.

## Features available

There are several pages available, dividing up features as much as possible:

 - the Main activity, the one showing when the app is started, has four voices and a text field:
   - The wallet summary: some information about the wallet state - but only after `SEED` and `WALLET_BIRTHDAY_HEIGHT` were set. Also, you need to first tap on `Reset database`, which also creates an account.
   - Reset database: it dumps and reinitialize the database and tables. It also creates the account which will be used for the spending operation.
   - Download blocks: it retrieves the last 60 blocks (as default, it may be set in `Constants`). It is useful when we want to use the spending feature.
   - Go to menu: it shows more features in another Activity.
   - Updated from db: it shows information updated on the Wallet summary text field.
 - the Menu activity has four "go-to" voices, which are:
   - Spend a note: it shows a screen where there are three actions to perform (after you received a note to spend from some faucet):
     - you can input an amount in ZATs
     - you can create a transaction
     - you can then submit it to the chain
   - Explore transaction: you can see the details of a transparent transaction,  or for a shielded transaction for which there is the viewing key in the database.
   - Decode Unified Address: paste a unified address and see the addresses it is composed of
   - Get transparent balance: paste a transparent address and get its total balance 
     - for quick testing there is a "paste address" feature, but you need to trigger manually the UI, e.g. canceling and adding the last letter/digit.

## Spending & Sync

Before being able to spend anything, you need to have the notes saved in the internal database. That means you need to download blocks AFTER the transaction is mined and confirmed.
So, in general, for spending, this is how an ideal scenario goes:
 - Write down the seed chosen for the wallet in `Constants`. It's an array of unsigned bytes. The minimum length is of 32 bytes.
 - You need also to set the test recipient address in `RECIPIENT_ADDRESS`.
 - After creating the wallet, you may get the transparent and shielded address so created. The shielded address belongs to the sapling pool.
 - Get TAZs to the **shielded** (Sapling) address [here](https://faucet.zecpages.com/) (or some other faucet for testnet).
 - Wait 5-10 minutes, check for example [here](https://blockexplorer.one/zcash/testnet) for when the transaction gets mined.
 - After you see that the transaction was mined and got at least one confirmation (or how many were set in `Constants`),
 - Tap on "Download blocks". You should see that the note was downloaded because it will be visible under spendable notes in the main page, or if you paste the transaction hash in "Explore the transaction".
 - You should be all set to go to "Spend a note", and follow from there.
 - Important: you will be able to spend the note only once, since additional synchronization requires more complexity. We believe this is an already good enough as starting point.

The default of the app is to use the testnet but that can be changed in `Constants`, together with all other defaults and settings.
