require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "reactnativehaptics"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["homepage"]
  s.license      = package["license"]
  s.authors      = package["author"]

  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => "https://github.com/rn-packages/react-native-haptics", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m}"

  s.dependency "React"
end
