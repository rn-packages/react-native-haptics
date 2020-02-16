//
//  HapticsType.swift
//  Haptics
//
//  Created by Anders Friis on 16/02/2020.
//  Copyright © 2020 Facebook. All rights reserved.
//

import Foundation
import UIKit

enum HapticsType: String, CaseIterable {
    case selection, impactLight, impactMedium, impactHeavy, notificationSuccess, notificationWarning, notificationError
    
    var feedbackType: FeedbackType {
        switch self {
        case .selection: return .selection
        case .impactLight, .impactMedium, .impactHeavy:
            var type = UIImpactFeedbackGenerator.FeedbackStyle.light
            
            switch self {
            case .impactLight:
                type = .light
            case .impactMedium:
                type = .medium
            case .impactHeavy:
                type = .heavy
            default: break
            }
            return .impact(style: type)
            
        case .notificationSuccess, .notificationWarning, .notificationError:
            var type = UINotificationFeedbackGenerator.FeedbackType.success
            
            switch self {
            case .notificationSuccess:
                type = .success
            case .notificationWarning:
                type = .warning
            case .notificationError:
                type = .error
            default: break
            }
            return .notification(type: type)
        }
    }
    
}

enum FeedbackType {
    case selection, impact(style: UIImpactFeedbackGenerator.FeedbackStyle), notification(type: UINotificationFeedbackGenerator.FeedbackType)
}
