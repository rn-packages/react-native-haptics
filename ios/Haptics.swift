//
//  Haptics.sw.swift
//  Haptics
//
//  Created by Anders Friis on 16/02/2020.
//  Copyright © 2020 Facebook. All rights reserved.
//

import Foundation
import UIKit

@objc(Haptics)
class Haptics: NSObject {

    @objc(trigger:)
    func trigger(type: String) {
        guard let typeEnum = HapticsType(rawValue: type) else {
            fatalError("Wrong HapticsType provided: \(type)")
        }
        
        switch typeEnum.feedbackType {
        case .selection:
           let generator = UISelectionFeedbackGenerator()
           generator.selectionChanged()
        
        case .impact(let style):
            let generator = UIImpactFeedbackGenerator(style: style)
            generator.impactOccurred()
            
        case .notification(let type):
            let generator = UINotificationFeedbackGenerator()
            generator.notificationOccurred(type)
        }
    }
    
}
