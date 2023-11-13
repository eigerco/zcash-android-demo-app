# Android demo app for Zcash

This is an app built for demonstration of the features of a UniFFI library translating the librustzcash library built by the ECC.

Some ground rules:
- it was not built to be used as a wallet. It doesn't contain a lot of basic instruments like error handling
- it is meant for developers to be ran
- it is meant to be used for debugging or as starting point for building a wallet-like application

Some pieces were taken from the [already existing SDK by the ECC](https://github.com/zcash/zcash-android-wallet-sdk), especially the protobuf for using lightwalletd.

