import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController()
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    init() {
        InitKoinKt.doInitKoin()
    }
    
    var body: some View {
        ComposeView()
                .ignoresSafeArea(.keyboard)
                .ignoresSafeArea(.container)
    }
}



