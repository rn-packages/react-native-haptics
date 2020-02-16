//
//  Haptics.h
//  Haptics
//
//  Created by Anders Friis on 16/02/2020.
//  Copyright © 2020 Facebook. All rights reserved.
//

#import <React/RCTBridgeModule.h>

@interface RCT_EXTERN_MODULE(Haptics, NSObject)

RCT_EXTERN_METHOD(trigger:(NSString *)type)

@end
