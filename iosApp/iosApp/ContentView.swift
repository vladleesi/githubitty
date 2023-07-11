import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
		ComposeView()
	}
}

struct PreviewView: View {
    let greet = Greeting().greet()

    var body: some View {
        Text(greet)
    }
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
        PreviewView()
	}
}
