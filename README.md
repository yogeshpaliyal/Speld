![](cover.jpeg)

# SPELD

![buildStatus](https://img.shields.io/github/actions/workflow/status/yogeshpaliyal/Speld/publish.yml?style=plastic&branch=master)
![latestVersion](https://img.shields.io/github/v/tag/yogeshpaliyal/Speld?display_name=tag)
<a href="https://twitter.com/yogeshpaliyal" target="_blank">
<img alt="Twitter: yogeshpaliyal" src="https://img.shields.io/twitter/follow/yogeshpaliyal.svg?style=social" />
</a>

> Android Compose OTP/PIN View


<img src="demo.png" width="30%" />

## Implementation
```groovy
implementation("com.yogeshpaliyal:speld:1.0.1")
```

### Default / Solid Pin View
```kotlin
val text = remember { mutableStateOf("") }
PinInput(value = text.value, obscureText = null) {
    text.value = it
}
```

### Bordered Pin View
```kotlin
val text = remember { mutableStateOf("") }
PinInput(
    cellModifier = Modifier.border(
        BorderStroke(2.dp, Color.Red),
        shape = RoundedCornerShape(3.dp)
    ), value = text.value,
    obscureText = "*",
    length = 6,
    disableKeypad = false // Optional
) {
    text.value = it
}
```

## ✍️ Author

👤 **Yogesh Choudhary Paliyal**

* Twitter: <a href="https://twitter.com/yogeshpaliyal" target="_blank">@yogeshpaliyal</a>
* Email: yogeshpaliyal.foss@gmail.com

Feel free to ping me 😉

## 🤝 Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any
contributions you make are **greatly appreciated**.

1. Open an issue first to discuss what you would like to change.
1. Fork the Project
1. Create your feature branch (`git checkout -b feature/amazing-feature`)
1. Commit your changes (`git commit -m 'Add some amazing feature'`)
1. Push to the branch (`git push origin feature/amazing-feature`)
1. Open a pull request

Please make sure to update tests as appropriate.

## ❤ Show your support

Give a ⭐️ if this project helped you!

<a href="https://www.patreon.com/yogeshpaliyal">
  <img alt="Patron Link" src="https://c5.patreon.com/external/logo/become_a_patron_button@2x.png" width="160"/>
</a>

<a href="https://www.buymeacoffee.com/yogeshpaliyal" target="_blank">
    <img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png" alt="Buy Me A Coffee" width="160">
</a>

<a href="https://www.paypal.me/yogeshpaliyal" target="_blank">
    <img src="https://www.paypalobjects.com/en_US/i/btn/btn_donateCC_LG.gif" alt="Donation" width="160">
</a>

## ☑️ TODO

- [x] Solid PIN View
- [x] Bordered PIN View

## 📝 License

```
Copyright © 2023 - Yogesh Choudhary Paliyal

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

_This README was generated by [readgen](https://github.com/theapache64/readgen)_ ❤
